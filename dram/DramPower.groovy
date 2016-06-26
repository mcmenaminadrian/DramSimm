package dram

class DramPower {
	
	def max_VDD
	def min_VDD
	def	VDD
	def P_per_DQ
	def density
	def DQ
	def DQS
	def IDD0
	def IDD2P
	def IDD2F
	def IDD3P
	def IDD3N
	def IDD4R
	def IDD4W
	def IDD5
	def t_CK
	def t_RC
	def t_RFC_min
	def t_REFI
	def VDD_scale
	def freq_scale /* Note this needs to be fixed everytime you change the dram frequency*/
	def	print_period
	def 	chip_count
  
	def ICC_Idle_0
	def ICC_Idle_1
	def ICC_Idle_2
	def ICC_Active_1
	def ICC_Active_2
	def VCC
  
	/* Pre-calcualted power values */
	def p_PRE_PDN
	def p_PRE_STBY
	def p_ACT_PDN
	def p_ACT_STBY
	def p_ACT
	def p_WR
	def p_RD
	def p_REF
	def p_DQ
  

}
