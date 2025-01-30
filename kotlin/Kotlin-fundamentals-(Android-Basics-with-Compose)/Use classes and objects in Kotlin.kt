/*
 * https://pl.kotl.in/7cB4c-yYb?theme=darcula
 */

/*
 * Ideally, you should strive for strict visibility of properties and methods, 
 * so declare them with the private modifier as often as possible. 
 * If you can't keep them private, use the protected modifier. 
 * If you can't keep them protected, use the internal modifier. 
 * If you can't keep them internal, use the public modifier.
 * 
 * https://developer.android.com/codelabs/basic-android-kotlin-compose-classes-and-objects?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-classes-and-objects#7
 */

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {
    
    var deviceStatus = "online"
    	protected set
        
    open val deviceType = "unknown"
    
    //secondary constructor
    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }
    
    open fun turnOn() {
        deviceStatus = "on"
    }
    
    open fun turnOff() {
        deviceStatus = "off"
    }
    
    open fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
	SmartDevice(name = deviceName, category = deviceCategory) {
        
    override val deviceType = "Smart TV"
        
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
        
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
    
    fun nextChannel() {
        channelNumber++
        println("Channel increased to $channelNumber.")
    }
    
    override fun turnOn() {
        super.turnOn()
        println(
            "$name turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber."
        )
    }
    
    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}
    
class SmartLightDevice(deviceName: String, deviceCategory: String) :
	SmartDevice(name = deviceName, category = deviceCategory) {
        
    override val deviceType = "Smart Light"
        
    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
        
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
    
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }
    
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("$name turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    
    var deviceTurnOnCount = 0
    	private set
    
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }
    
    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }
    
    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }
    
    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }
    
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }
    
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {
    
    var fieldData = initialValue
    
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }
    
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    
    val TV = SmartTvDevice("Android TV", "Entertainment")
    val Light = SmartLightDevice("Android Light", "LED")
    
    var smartDevice: SmartDevice = SmartTvDevice("Apple TV", "Entertainment")
    smartDevice.turnOn()
    
    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
    
    TV.turnOn()
    TV.increaseSpeakerVolume()
    TV.nextChannel()
    
    Light.turnOn()
    Light.increaseBrightness()
    
    TV.printDeviceInfo()
}