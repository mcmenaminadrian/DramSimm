package dram

class DramSystem {
	def currentDramTime
	def lastDramTime
	def currentMcTime
	def lastMcTime
	DramSystemConfiguration config
	DramController dramController = []
	GlobalTqInfo tqInfo
	PowerInfo dramPower
	
	DramSystem(Biu globalBiu)
	{
		config = new DramSystemConfiguration(globalBiu)
		tqInfo = new GlobalTqInfo()
	}

}
