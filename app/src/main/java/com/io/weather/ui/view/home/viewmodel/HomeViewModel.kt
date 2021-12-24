package com.io.weather.ui.view.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.io.weather.R
import com.io.weather.common.Loading
import com.io.weather.common.LoadingError
import com.io.weather.common.LoadingState
import com.io.weather.common.LoadingSuccess
import com.io.weather.model.WeatherModel
import com.io.weather.room.WeatherDatabase
import com.io.weather.room.entity.CityInfo
import com.io.weather.utils.*
import com.qweather.sdk.bean.air.AirNowBean
import com.qweather.sdk.bean.base.Lang
import com.qweather.sdk.bean.weather.WeatherHourlyBean
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.IllegalStateException
import javax.inject.Inject

/**
 * @desc
 *
 * @author Vo7ice on 2021-12-23
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val homeRepository: HomeRepository
) : AndroidViewModel(application) {
    private var language: Lang = application.getDefaultLocale()
    private var cityInfoDao = WeatherDatabase.getDatabase(application).cityInfoDao()
    private var weatherJob: Job? = null
    private var refreshCityJob: Job? = null
    private var updateCityJob: Job? = null

    private val _searchCityInfo = MutableLiveData(0)
    val searchCItyInfo: LiveData<Int> = _searchCityInfo

    fun onSearchCityInfoChanged(page: Int) {
        if (page != _searchCityInfo.value) {
            XLog.d("onSearchCityInfoChanged no change!")
            return
        }
        _searchCityInfo.postValue(page)
    }

    private val _cityInfoList = MutableLiveData(listOf<CityInfo>())
    val cityInfoList: LiveData<List<CityInfo>> = _cityInfoList

    private fun onCityInfoListChanged(list: List<CityInfo>) {
        if (list == _cityInfoList.value) {
            XLog.d("onCityInfoListChanged no change!")
            return
        }
        _cityInfoList.postValue(list)
    }

    private val _weatherModel = MutableLiveData<LoadingState<WeatherModel>>(Loading)
    val weatherModel: LiveData<LoadingState<WeatherModel>> = _weatherModel

    private fun onWeatherModelChanged(loadingState: LoadingState<WeatherModel>) {
        if (loadingState == _weatherModel.value) {
            XLog.d("onWeatherModelChanged no change!")
            return
        }
        _weatherModel.postValue(loadingState)
    }

    fun getWeather(location: String) {
        if (!getApplication<Application>().checkNetState()) {
            showToast(getApplication(), R.string.bad_network_view_tip)
            onWeatherModelChanged(LoadingError(IllegalStateException("当前没有网络!")))
            return
        }
        weatherJob.checkCoroutines()
        weatherJob = viewModelScope.launch(Dispatchers.IO) {
            val weatherNow = homeRepository.getWeatherNow(location, language)
            val weatherOneDay = arrayListOf<WeatherHourlyBean.HourlyBean>()
            val weatherOneWeek = homeRepository.getWeatherOneWeek(location, language)
            val airNow = AirNowBean.NowBean()

            val weatherModel = WeatherModel(
                nowBaseBean = weatherNow,
                hourlyBeanList = weatherOneDay,
                dailyBean = weatherOneWeek.first,
                dailyBeanList = weatherOneWeek.second,
                airNowBean = airNow
            )

            withContext(Dispatchers.Main) {
                onWeatherModelChanged(LoadingSuccess(weatherModel))
            }
        }
    }

}