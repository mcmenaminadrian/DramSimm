package dram

class Command {

	def status
	def startTime
	def command
	def chanID
	def rankID
	def bankID
	def rowID
	def colID
	def completionTime
	def startTransmissionTime
	def linkCommTranCompTime
	def dramProcCompTime
	def dimmDataTranCompTime
	def ambDownProcCompTime
	def linkDataTranCompTime
	def rankDoneTime
	
	def bundleID
	long tranID
	def dataWord
	def dataWordPosition
	def refresh
	def rqNextC //command
	def postedCAS
	def cmdChkedForScheduling
	def cmdUpdated
	def cmdID
	def nextC //command
}
