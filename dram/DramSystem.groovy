package dram

class DramSystem {
	
	def		dram_type					/* SDRAM, DDRSDRAM,  etc. */
	def		memory_frequency			/* clock freq of memory controller system, in MHz */
	def		dram_frequency				/* FB-DIMM only clock freq of the dram system, in MHz */
	def 	memory2dram_freq_ratio		/* FBD-DIMM multiplier for timing */
	long		dram_clock_granularity		/* 1 for SDRAM, 2 for DDR and etc */
	def		critical_word_first_flag	/* SDRAM && DDR SDRAM should have this flag set, */

	def		physical_address_mapping_policy/* which address mapping policy for Physical to memory? */
	def     row_buffer_management_policy   /* which row buffer management policy? OPEN PAGE, CLOSE PAGE, etc */
	def     refresh_policy   				/* What refresh policies are applied */
	def     refresh_issue_policy   				/* Should we issue at once or when opportunity arises*/

	def		cacheline_size			/* size of a cacheline burst, in bytes */
	def		channel_count			/* How many logical channels are there ? */
	def		channel_width			/* How many bytes width per logical channel? */
	def		up_channel_width	/* FB-DIMM : Up channel width in bits */
	def		down_channel_width	/* FB-DIMM : Down channel width in bits */
	def 	rank_count			/* How many ranks are there on the channel ? */
	def		bank_count			/* How many banks per device? */
	def		row_count			/* how many rows per bank? */
	def		col_count			/* Hwo many columns per row? */
	def     packet_count           /*   cacheline_size / (channel_width * 8) */
	  
	def max_tq_size
							/* we also ignore t_pp (min prec to prec of any bank) and t_rr (min ras to ras).   */
	def		data_cmd_count		/** For FBDIMM : Reqd to determine how many data "commands" need to be sent **/
	def		drive_cmd_count		/** For FBDIMM : Reqd to determine how many drive "commands" need to be sent currently set to 1**/
	def     	t_burst          		/* number of cycles utilized per cacheline burst */
	def		t_cas				/* delay between start of CAS command and start of data burst */
	def		t_cmd				/* command bus duration... */
	def		t_cwd				/* delay between end of CAS Write command and start of data packet */
	def		t_cac				/* delay between end of CAS command and start of data burst*/
	def		t_dqs				/* rank hand off penalty. 0 for SDRAM, 2 for DDR, and */
	long		t_faw				/* four bank activation */
	def		t_ras				/* interval between ACT and PRECHARGE to same bank */
	def		t_rc				/* t_rc is simply t_ras + t_rp */
	def		t_rcd				/* RAS to CAS delay of same bank */
	long	t_rrd				/* Row to row activation delay */
	def	t_rp				/* interval between PRECHARGE and ACT to same bank */
	def		t_rfc				/* t_rfc -> refresh timing : for sdram = t_rc for ddr onwards its t_rfc (refer datasheetss)*/
	def		t_wr				/* write recovery time latency, time to restore data o cells */
	def		t_rtp				/* Interal READ-to-PRECHARGE delay - reqd for CAS with PREC support prec delayed by this amount */

	def		posted_cas_flag		/* special for DDR2 */
	def		t_al				/* additive latency = t_rcd - 2 (ddr half cycles) */
	
	def		t_rl				/* read latency  = t_al + t_cas */
	def		t_rtr				/* delay between start of CAS Write command and start of write retirement command*/

	def		t_bus					/* FBDIMM - bus delay */
	def		t_amb_up				/* FBDIMM - Amb up delay  - also the write buffer delay*/
	def		t_amb_down				/* FBDIMM - Amb down delay - also the read buffer delay  Note that this implies the first 2 bursts are packaged and sent down in this time later -> overlap of dimm and link burst is seen*/
	def		t_amb_forward				/* FBDIMM - Amb to AMB forwarding delay */
	long     t_bundle          		/* FBDIMM number of cycles utilized to transmit a bundle */
	def		up_buffer_cnt			/* FBDIMM	number of buffers available at the AMB for write cmds  1 buffer => 1 cache line*/
	def		down_buffer_cnt		/* FBDIMM	number of buffers available at the AMB for read cmds */
	def		var_latency_flag		/* FBDIMM	Set when the bus latency is to not rank dependent */
	def		row_command_duration
	def		col_command_duration
	def     auto_refresh_enabled       /* interleaved autorefresh, or no refresh at all */
  
	def		refresh_time			/* given in microseconds. Should be 64000. 1 us is 1 MHz, makes the math easier */
	def		refresh_cycle_count		/* Every # of DRAM clocks, send refresh command */
	def 	watch_refresh
	long ref_tran_id
 
	def arrival_threshold
	def		strict_ordering_flag		/* if this flag is set, we cannot opportunistically allow later */
							/* CAS command to by pass an earlier one. (earlier one may be waiting for PREC+RAS) */
							/* debug flags turns on debug printf's */
	def		dram_debug
	def		addr_debug			/* debug the address mapping schemes */
	def		wave_debug			/* draw cheesy waveforms */
	def		issue_debug			/* Prints out when things got issued - DDRX */
	def		wave_cas_debug			/* draw cheesy waveforms of cas activity only*/
	def		bundle_debug			/* for FBDIMM */
	def		amb_buffer_debug		/* for FBDIMM */
	def		tq_delay				/* How many DRAM delay cycles should the memory controller add for delay through the transaction queue? */

	def	single_rank // true - Number of ranks per dimm=1 else false for dual rank systems
	def 	num_thread_sets
	def		thread_sets = [/*32*/] // need to make this some const
	def 	thread_set_map = [/*32*/]

	def    cas_with_prec // For close page systems this will be used

	//class?
	DramPower dram_power_config
	 // power_config_t dram_power_config	/* Power Configuration */


	
	DramSystem()
	{
		
	
	}
}
