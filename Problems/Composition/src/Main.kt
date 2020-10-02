// write the classes here
class OperatingSystem(){
  var name : String = "Windows"
}
class DualBoot(){
    lateinit var primaryOs : OperatingSystem
    lateinit var secondaryOs : OperatingSystem
}