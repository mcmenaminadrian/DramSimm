package dram

class GlobalTqInfo {

	def debugFlag
	long debugTranIdThreshold
	def numIfetchTran
	def numReadTran
	def numPrefetchTran
	def numWriteTran
	long tranWatchId
	def tranWatchFlag
	long transactionIdCtr
	Command freeCommandPool
	def lastTransactionRetiredTime
}
