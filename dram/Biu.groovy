package dram

//typedef struct biu_t {
//	tick_t		current_cpu_time;
//	def		bus_queue_depth;
//	def     active_slots;
//	def     critical_word_rdy_slots;
//	biu_slot_t	slot[MAX_BUS_QUEUE_DEPTH];
//	def		fixed_latency_flag;
//	tick_t		delay;		/* How many CPU delay cycles should the bus queue add? */
//							/* debug flags turns on debug prdeff's */
//	def		debug_flag;
//	def		access_count[MEMORY_ACCESS_TYPES_COUNT];
//	def		proc_request_count[MAX_PROCESSOR];
//							/* where to dump out the stats */
//	FILE 		*biu_stats_fileptr;
//	FILE        *biu_trace_fileptr;

//	def		prefetch_biu_hit;		/* How many were eventually used? */
//	def		prefetch_entry_count;		/* how many prefetches were done? */
//	def		cpu_frequency;			/* cpu frequency now kept here */
//	def             mem_frequency;               	/* a "copy" of memory frequency is kept here so sim-cms can do a bit of an optimization */
//	tick_t          current_dram_time;              /* this is what biu expects the DRAM time to be based on its own computations, not the
//							real DRAM time. The real DRAM time should be the same as this one, but it's kept defhe dram system */
//	def             transaction_selection_policy;
//	def             thread_count;                   /* how many threads are there on the cpu? */
//	double 		mem2cpu_clock_ratio;
//	double		cpu2mem_clock_ratio;
//	def		max_write_burst_depth;		/* If we're doing write sweeping, limit to this number of writes*/
//	def		write_burst_count;		/* How many have we done so far?*/
//	dram_system_configuration_t  *dram_system_config; /* A podefer to the DRAM system configuration is kept here */
//	def     last_bank_id;
//	def     last_rank_id;
//	def     last_transaction_type;
//	tick_t  last_transaction_time;
//} biu_t;


//void init_biu(biu_t *);
//biu_t *get_biu_address();
//void set_biu_address(biu_t *);
//void set_dram_chan_count_in_biu( def);
//void set_dram_chan_width_in_biu( def);
//void set_dram_cacheline_size_in_biu( def);
//void set_dram_rank_count_in_biu( def);
//void set_dram_bank_count_in_biu( def);
//void set_dram_row_count_in_biu( def);
//void set_dram_col_count_in_biu( def);
//void set_dram_address_mapping_in_biu( def);
//void set_biu_depth( def);
//def  get_biu_depth(biu_t *);
//void set_biu_delay( def);
//def  get_biu_delay(biu_t *);
//void set_cpu_dram_frequency_ratio( def);
//def  biu_hit_check( def, unsigned def, def, def, tick_t);	/* see if request is already in biu. If so, then convert transparently */
//def  find_free_biu_slot( def);
//#ifdef ALPHA_SIM
//void fill_biu_slot( def, def, tick_t, def, unsigned def, def, def, struct _cache_access_packet *,RELEASE_FN_TYPE);	/* slot_id, thread_id, now, rid, block address */
//#endif // SIM_MASE use this

//#ifdef SIM_MASE
//void fill_biu_slot( def, def, tick_t, def, unsigned def, def, def, void *, void (*callback_fn)(def, def));	/* slot_id, thread_id, now, rid, block address */
//#endif

//#ifdef GEMS// This is true for the GEMS and mem-test versions
//void fill_biu_slot( def, def, tick_t, def, unsigned def, def, def, void *, RELEASE_FN_TYPE);	/* slot_id, thread_id, now, rid, block address */
//#endif
//#ifdef MEM_TEST// This is true for the GEMS and mem-test versions
//void fill_biu_slot( def, def, tick_t, def, unsigned def, def, def, void *, RELEASE_FN_TYPE);	/* slot_id, thread_id, now, rid, block address */
//#endif

//RELEASE_FN_TYPE biu_get_callback_fn(biu_t *this_b,def slot_id) ;

//void *biu_get_access_sim_info(biu_t *this_b,def slot_id) ;
//void release_biu_slot( def);
//def  get_next_request_from_biu(biu_t *);				/* find next occupied bus slot */
//def  get_next_request_from_biu_chan(def);				/* find next occupied bus slot */
//def  bus_queue_status_check( def);
//def  dram_update_required( tick_t);
//def  find_critical_word_ready_slot( def);
//def  find_completed_slot( def, tick_t);
//def  num_free_biu_slot(biu_t *);
//void squash_biu_entry_with_rid( def);

//def  get_rid( def);
//def  get_access_type( def);
//tick_t get_start_time( def);
//unsigned def get_virtual_address( def);
//unsigned def get_physical_address( def);
//void set_critical_word_ready( def);
//def  critical_word_ready( def);
//def  callback_done( def);
//void biu_invoke_callback_fn( def);

//void set_biu_slot_status( def, def);
//def  get_biu_slot_status( def);

//void set_biu_debug( def);
//def  biu_debug(biu_t *);
//void set_biu_fixed_latency( def);
//def  biu_fixed_latency(biu_t *);

//void prdef_access_type(def,FILE *);
//void prdef_biu(biu_t *);
//void prdef_biu_access_count(FILE *);
//void set_current_cpu_time( tick_t);				/* for use with testing harness */
//void set_cpu_frequency(def);
//def  get_cpu_frequency(biu_t *);
//tick_t get_current_cpu_time(biu_t *);

//void set_transaction_selection_policy(def);
//def  get_transaction_selection_policy(biu_t *);

//void set_last_transaction_type(def);
//def  get_previous_transaction_type(biu_t *);
//def get_biu_queue_depth (biu_t *this_b);

//def next_RBRR_RAS_in_biu(biu_t *this_b, def rank_id, def bank_id);
/* cms specific stuff */

//def  get_thread_id( def);
//void set_thread_count( def);
//def  get_thread_count(biu_t *);

//void scrub_biu(def);
//void biu_set_mem_cfg(biu_t*this_b,dram_system_configuration_t * cfg_ptr);
//#ifdef ALPHA_SIM
//def is_biu_busy(biu_t* this_b);
//#else
//bool is_biu_busy(biu_t* this_b);
//#endif
//void gather_biu_slot_stats(biu_t*);

//extern def shmid;
//extern def semid;
//extern def thread_id;

//extern biu_t *global_biu;



class Biu {

def current_cpu_time
def bus_queue_depth
def active_slots
def critical_word_rdy_slots
def slot = []
def fixed_latency_flag
def delay

def debug_flag
def access_count = []
def proc_request_count = []
def biu_stats_fileptr
def biu_trace_fileptr

def prefetch_biu_hit
def prefetch_entry_count
def cpu_frequency
def mem_frequency
def current_dram_time
def transaction_selection_policy
def thread_count
def mem2cpu_clock_ratio
def cpu2mem_clock_ratio
def max_write_burst_depth
def write_burst_count
def dram_system_config
def last_bank_id
def last_rank_id
def last_transaction_type
def last_transaction_time
//static def global_biu

//void init_biu(biu_t *);

Biu(){
	
//	global_biu = this
	current_cpu_time = 0
	bus_queue_depth = 0
	for (i in 0 .. MAX_BUS_QUEUE_DEPTH) {
		slot[i].status = MEM_STATE_INVALID
	}
	delay = 1
	debug_flag = false
	for (i in 0 .. MEMORY_ACCESS_TYPES_COUNT) {
		access_count[i] = 0
	}
	prefetch_biu_hit = 0
	current_dram_time = 0
	last_transaction_type = MEM_STATE_INVALID
	max_write_burst_depth = 8
	write_burst_count = 0
	biu_trace_fileptr = null
	active_slots = 0
	critical_word_rdy_slots = 0
}

static Biu get_biu_address(){
	return this //global_biu
}

void set_biu_address(){
	//global_biu = this
}


void set_dram_chan_count_in_biu(def i) {
	
}

void set_dram_chan_width_in_biu(def width) 
{
	
}

void set_dram_cacheline_size_in_biu(def size)
{
	
}

void set_dram_rank_count_in_biu(def count)
{
	last_rank_id = count - 1
}

void set_dram_bank_count_in_biu(def count)
{
	last_bank_id = count - 1
}

void set_dram_row_count_in_biu(def count)
{
	
}

void set_dram_col_count_in_biu(def count)
{
	
}

void set_dram_address_mapping_in_biu(def policy)
{
	
}

void set_biu_depth(def depth)
{
	bus_queue_depth = max(1, depth)
}

def get_biu_depth()
{
	return bus_queue_depth
}


void set_biu_delay(def delay_value)
{
	delay = max(0, delay_value)
}


def get_biu_delay()
{
	return delay
}

//void set_cpu_dram_frequency_ratio(def ); //dead?

/* see if request is already in biu. If so, then convert transparently */

def biu_hit_check(def access_type, def baddr, def priority, def rid, def now)
{
  def i, match_found
  def bus_queue_depth

  bus_queue_depth = this.bus_queue_depth
  assert (bus_queue_depth <= MAX_BUS_QUEUE_DEPTH)
  match_found = false
  for (i = 0; i<bus_queue_depth && (match_found == FALSE); i++){
	  if((slot[i].status != MEM_STATE_INVALID) &&
		  (slot[i].address.physical_address == baddr) &&
		  (slot[i].access_type == MEMORY_PREFETCH)) {
		  		if ((access_type == MEMORY_IFETCH_COMMAND) ||
				  (access_type == MEMORY_READ_COMMAND)){
				  		slot[i].rid = rid
						prefetch_biu_hit++	
						slot[i].access_type = access_type
						slot[i].callback_done = false
						match_found = true
		} else if (access_type == MEMORY_PREFETCH) {
			if (priority < slot[i].priority) {
					slot[i].priority = priority;
			}
			match_found = true;
		}
	}
  }
  return match_found;
}
  
def find_free_biu_slot(def priority)
{
	def i
	def victim_id = MEM_STATE_INVALID
	def victim_found = false
	def bus_queue_depth
	
	bus_queue_depth = this.bus_queue_depth
	assert(bus_queue_depth <= MAX_BUS_QUEUE_DEPTH)
	
	if (active_slots != bus_queue_depth) {
		for (i = 0; i < bus_queue_depth; i++) {
			if (slot[i].status == MEM_STATE_INVALID) {
				return i
			}
		}
	}
	
	//Look for speculative prefetch entry to sacrifice
	victim_found = false
	for (i = 0; i < bus_queue_depth; i++) {
		if ((slot[i].access_type == MEMORY_PREFETCH) &&
			(slot[i].status == MEM_STATE_INVALID)) {
			if (victim_found) {
				if (slot[i].priority > slot[victim_id].priority) {
					victim_id = i
				}
			} else {
				victim_found = true
				victim_id = i
			}
		}
	}
	if (victim_found && ((priority == MEM_STATE_INVALID) ||
		(priority < slot[victim_id].priority))) {
		active_slots--
		return victim_id
	} else {
		return MEM_STATE_INVALID	
	}
}


def biu_get_callback_fn(def slot_id)
{
	return slot[slot_id].callback_fn
}

def biu_get_access_sim_info(def slot_id)
{
	return null
}

void release_biu_slot(def sid)
{
	if (biu_debug()) {
		prdef "BIU release sid: $sid rid: ${slot[sid].rid} "
		prdef "access_type ${prdef_access_type(slot[sid].access_type)} "
		prdefln "addr [${slot[sid].address.physical_address}]"
	}
	
	slot[sid].status = MEM_STATE_INVALID
	slot[sid].thread_id = MEM_STATE_INVALID
	slot[sid].rid = MEM_STATE_INVALID
	access_count[slot[sid].access_type]++
	slot[sid].access_type = MEM_STATE_INVALID
	slot[sid].critical_word_ready = false
	slot[sid].callback_done = false
	slot[sid].callback_fn = null
	active_slots--
}



/* find next occupied bus slot */
/* look in the bus queue to see if there are any requests that needs to be serviced
 * Part of the logic exists to ensure that the "slot" only becomes active to the
 * DRAM transaction scheduling mechanism after this_b->delay has occured.
 */

def get_next_request_from_biu()
{
	def i
	def candidate_id = MEM_STATE_INVALID
	def candidate_time = 0
	def candidate_priority
	
	def bus_queue_depth = this.bus_queue_depth
	assert(bus_queue_depth <= MAX_BUS_QUEUE_DEPTH)
	def priority_scheme = transaction_selection_policy
	def last_transaction_type = this.last_transaction_type 
	def found = false
	
	if (priority_scheme == HTSP) {
		for (i = 0; i < bus_queue_depth; i++) {
			if ((slot[i].status == MEM_STATE_INVALID) && ((current_cpu_time -
				slot[i].start_time) > delay) {
				if (!found) {
					found = true
					candidate_priority = slot[i].priority
					candidate_time = slot[i].start_time
					candidate_id = i
				} else if (slot[i].priority == candidate_priority) {
					if (slot[i].start_time < candidate_time) {
						candidate_priority = slot[i].priority
						candidate_time = slot[i].start_time
						candidate_id = i
					}
				}
			}
		}
		if (found) {
			return candidate_id
		} else {
			return MEM_STATE_INVALID
		}
	} else {
		for (i = 0; i < bus_queue_depth; i++) {
			if ((slot[i].status == MEM_STATE_INVALID) && 
				((current_cpu_time - slot[i].start_time) > delay)) {
					if (!found) {
						found = true
						candidate_time = slot[i].start_time
						candidate_id = i
					} else if (slot[i].start_time < candidate_time) {
						candidate_time = slot[i].start_time
						candidate_id = i
					}
			}
		}
		if (found) {
			return candidate_id
		} else {
			return MEM_STATE_INVALID
		}
	}
	return MEM_STATE_INVALID
}

/* find next occupied bus slot */

/* look in the bus queue to see if there are any requests that needs to be serviced
 * Part of the logic exists to ensure that the "slot" only becomes active to the
 * DRAM transaction scheduling mechanism after delay has occured.
 * This mechanism ensures that the biu can move transactions based on commands
 * - address translation is done in the biu. Assuming biu and tq are on the
 *   same structure -
 */

def  get_next_request_from_biu_chan(def chan_id)
{
	def i
	def found = false
	def candidate_id = MEM_STATE_INVALID
	def candidate_time = 0
	def candidate_priority
	def bus_queue_depth = this.bus_queue_depth
	assert(bus_queue_depth <= MAX_BUS_QUEUE_DEPTH)
	def priority_scheme = transaction_selection_policy
	def last_transaction_type = this.last_transaction_type
	
	if (priority_scheme == HTSP) {
		for (i = 0; i < bus_queue_depth; i++) {
			if ((slot[i].status == MEM_STATE_INVALID) &&
				(slot[i].address.chan_id == chan_id) &&
				((current_cpu_time - slot[i].start_time) > delay) {
					if (!found) {
						found = true
						candidate_priority = slot[i].priority
						candidate_time = slot[i].start_time
						candidate_id = i
					} else if (slot[i].priority < candidate_priority &&
						slot[i].address.chan_id == chan_id) {
						candidate_priority = slot[i].priority
						candidate_time = slot[i].start_time
						candidate_id = i
					} else if (slot[i].priority == candidate_priority &&
						slot[i].address.chan_id == chan_id) {
						if (slot[i].start_time < candidate_time) {
							candidate_priority = slot[i].priority
							candidate_time = slot[i].start_time
							candidate_id = i
						}
					}
				}
			}
		if (found) {
			return candidate_id
		} else {
			return MEM_STATE_INVALID
		}
	} else {
		for (i = 0; i < bus_queue_depth; i++) {
			if ((slot[i].status == MEM_STATE_INVALID) &&
				(slot[i].address.chan_id == chan_id) &&
				((current_cpu_time - slot[i].start_time) > delay)) {
				if (!found) {
					found = true
					candidate_time = slot[i].start_time
					candidate_id = i
				} else if ((slot[i].start_time < candidate_time && 
					slot[i].address.chan_id == chan_id)) {
					candidate_time = slot[i].start_time
					candidate_id = i
			}
		}
		}
		if (found) {
			return candidate_id
		} else {
			return MEM_STATE_INVALID
		}
	}
	return MEM_STATE_INVALID
}
				
def bus_queue_status_check(def thread_id)
{
	def i
	def bus_queue_depth = this.bus_queue_depth
	
	if (thread_id == MEM_STATE_INVALID) {
		for (i = 0; i < bus_queue_depth; i++) {
			if ((slot[i].status == MEM_STATE_INVALID) || 
				(slot[i].status == MEM_STATE_SCHEDULED)) {
				return BUSY
			}
		}
	} else {
		for (i = 0; i < bus_queue_depth; i++) {
			if ((slot[i].thread_id == thread_id) && 
				((slot[i].status == MEM_STATE_VALID) || 
				(slot[i].status == MEM_STATE_SCHEDULED))) {
				return BUSY
			}
		}
		if (num_free_biu_slot() <= 5) { /* hard coded */
			/* even if I have no requests outstanding, 
			 * if the bus queue is filled up, it needs to be serviced */
			return BUSY
		}
	}
	return IDLE
}


  

def dram_update_required(def current_cpu_time)
{
	def expected_dram_time
	def mem2cpu_clock_ratio = this.mem2cpu_clock_ratio
	
	expected_dram_time = current_cpu_time * mem2cpu_clock_ratio
	
	if (expected_dram_time - current_dram_time > 1) {
		return true
	} else {
		return false
	}
}

def find_critical_word_ready_slot(def thread_id)
{
	def i
	def latency
	def bus_queue_depth = this.bus_queue_depth
	assert(bus_queue_depth <= MAX_BUS_QUEUE_DEPTH)
	
	if (active_slots == 0 || critcal_word_rdy_slots == 0) {
		return MEM_STATE_INVALID
	}
	
	for (i = 0; i < bus_queue_depth; i++) {
		if ((slot[i].thread_id == thread_id) && slot[i].critical_word_ready &&
			!(slot[i].callback_done)) {
			// Keeps track of those whose callback you want to do
			critical_word_rdy_slots-- 
			slot[i].callback_done = true
			latency = current_cpu_time - slot[i].start_time
			if ((slot[i].access_type == MEMORY_IFETCH_COMMAND) ||
				(slot[i].access_type == MEMORY_READ_COMMAND)) {
				/* gather stat for critical reads only */
				mem_gather_stat(GATHER_BUS_STAT, latency)
				if (biu_debug()) {
					prdef "BIU: Critical Word Received sid [$i] "
					prdef "rid [${slot[i].rid}"
					prdef_access_type(slot[i].access_type)
					prdef "] addr [${slot[i].address.physical_address}] "
					prdef "Now[$current_cpu_time] Latency ["
					prdefln "${current_cpu_time - slot[i].start_time}]"
				}
			}
			return i
		}
	}
	return MEM_STATE_INVALID
}
  

def find_completed_slot(def thread_id, def now)
{
	def i
	def access_type
	def bus_queue_depth = this.bus_queue_depth
	assert(bus_queue_depth <= MAX_BUS_QUEUE_DEPTH)
	
	if (active_slots == 0) {
		return MEM_STATE_INVALID
	}
	
	for (i = 0; i < bus_queue_depth; i++) {
		if (slot[i].status == MEM_STATE_COMPLETED && 
			slot[i].thread_id == thread_id) {
			access_type = get_access_type(i)
			def latency = current_cpu_time - slot[i].start_time
			if (!callback_done(i) && (access_type == MEMORY_IFETCH_COMMAND ||
				access_type == MEMORY_READ_COMMAND)) {
				mem_gather_stat(GATHER_BUS_STAT, latency)
			}
			return i
		}
	}
	return MEM_STATE_INVALID
}

/*
 * Determine the Number of free biu slots currently available
 * Used by simulators to probe for MEM_RETRY situations
 */
def num_free_biu_slot()
{
	assert(bus_queue_depth <= MAX_BUS_QUEUE_DEPTH)
	def j = 0
	for (def i = 0; i < bus_queue_depth; i++) {
		if (slot[i].status == MEM_STATE_INVALID) {
			j++
		}
	}
	return j
}

//void squash_biu_entry_with_rid( def);

def get_rid(def slot_id)
{
	return slot[slot_id].rid
}

def get_access_type(def slot_id)
{
	return slot[slot_id].access_type
}

def get_start_time(def slot_id)
{
	return slot[slot_id].start_time
}

def get_virtual_address(def slot_id)
{
	return slot[slot_id].address.virtual_address
}

def get_physical_address(def slot_id)
{
	return slot[slot_id].address.physical_address
}

void set_critical_word_ready(def slot_id)
{
	critcal_wrd_ready_slots++
	slot[slot_id].critical_word_ready = true
}

def critical_word_ready(def slot_id)
{
	return slot[slot_id].critical_word_ready
}

def callback_done(def sid)
{
	return slot[sid].callback_done
}

//void biu_invoke_callback_fn(def ) - for simulators?

void set_biu_slot_status(def slot_id, def status)
{
	slot[slot_id].status = status
}

def  get_biu_slot_status(def slot_id)
{
	return slot[slot_id].status
}

void set_biu_debug(def debug_status)
{
	debug_flag = debug_status
}

def biu_debug()
{
	return debug_status
}

void set_biu_fixed_latency(def flag_status)
{
	fixed_latency_flag = flag_status
}

def biu_fixed_latency()
{
	return fixed_latency_flag	
}

void print_access_type(def type)
{
	switch(type) {
		case MEMORY_UNKNOWN_COMMAND:
		  print "UNKNOWN"
		  break;
		case MEMORY_IFETCH_COMMAND:
		  print "IFTECH "
		  break;
		case MEMORY_WRITE_COMMAND:
		  print "WRITE  "
		  break;
		case MEMORY_READ_COMMAND:
		  print"READ   "
		  break;
		case MEMORY_PREFETCH:
		  print"P_FETCH"
		  break;
		default:
		  print "UNKNOWN"
		  break;
	  }
}

void print_biu()
{
	assert(bus_queue_depth <= MAX_BUS_QUEUE_DEPTH)
	for (def i = 0; i < bus_queue_depth; i++) {
		if (slot[i].status != MEM_STATE_INVALID) {
			print "Entry [$i] Status [${slot[i].status}] Rid [${slot[i].rid}] "
			print "Start_time [${slot[i].start_time}] "
			print "Addr [${slot[i].address.physical_address}]"
			print_access_type(slot[i].access_type)
			println
		}
	}
}

void print_biu_access_count()
{
	def i
	def total_count = 1
	for (i = 0; i < MEMORY_ACCESS_TYPES_COUNT; i++) {
		total_count += access_count[i]
	}		
	println "TOTAL Count = [$total_count] percentage = [100.00]"
	for (i = 0; i < MEMORY_ACCESS_TYPES_COUNT; i++) {
		print_access_type(i)
		print " Count = [${access_count[i]}] percentage = ["
		println "${100.0 * access_count[i]/total_count}]"
	}
}

/* for use with testing harness */
void set_current_cpu_time(def current_time)
{
	current_cpu_time = current_time
}

void set_cpu_frequency(def freq)
{
	if (freq < MIN_CPU_FREQUENCY) {
		cpu_frequency = MIN_CPU_FREQUENCY;
		println "WARNING: CPU frequency set to minimum allowed frequency \\\
			[$cpu_frequency] MHz"
	} else if (freq > MAX_CPU_FREQUENCY) {
		cpu_frequency = MAX_CPU_FREQUENCY
		println "WARNING: CPU frequency set to maximum allowed frequency \\\
		[$cpu_frequency] MHz"
	 } else {
	  	cpu_frequency = freq
	 }
}

def  get_cpu_frequency()
{
	return cpu_frequency
}

def get_current_cpu_time()
{
	return current_cpu_time
}

void set_transaction_selection_policy(def policy)
{
	transaction_selection_policy = policy
}

def  get_transaction_selection_policy()
{
	return transaction_selection_policy
}

void set_last_transaction_type(def type)
{
	last_transaction_type = type
}

def get_last_transaction_type()
{
	return last_transaction_type
}

def get_biu_queue_depth()
{
	return bus_queue_depth
}

def next_RBRR_RAS_in_biu(def rank_id, def bank_id)
{
	def i
	assert(bus_queue_depth <= MAX_BUS_QUEUE_DEPTH)
	for (i = 0; i < bus_queue_depth; i++) {
		if (slot[i].status == MEM_STATE_VALID && (
			slot[i].access_type == MEMORY_READ_COMMAND ||
			slot[i].access_type == MEMORY_IFETCH_COMMAND) &&
			slot[i].address.bank_id == bank_id && slot[i].address.rank_id ==
			rank_id && ((current_cpu_time - slot[i].start_time) > delay)) {
			return i
		}
	}
	return MEM_STATE_INVALID
}
/* cms specific stuff */

def  get_thread_id(def slot_id)
{
	return slot[slot_id].thread_id
}

void set_thread_count(def count_threads)
{
	thread_count = count_threads
}

def  get_thread_count()
{
	return thread_count
}

void scrub_biu(def thread_id)
{
	def i
	assert(bus_queue_depth <= MAX_BUS_QUEUE_DEPTH)
	for (i = 0; i < bus_queue_depth; i++) {
		if (slot[i].thread_id == thread_id) {
			release_biu_slot(i)
		}
	}
}

void biu_set_mem_cfg(def cfg_ptr)
{
	dram_system_config = cfg_ptr
}


def is_biu_busy()
{
	if (active_slots > 0) {
		return true
	}
	return false
}

void gather_biu_slot_stats()
{
	mem_gather_stat(GATHER_BIU_SLOT_VALID_STAT, active_slots)
}
/*
extern def shmid;
extern def semid;
extern def thread_id;

extern biu_t *global_biu;
*/


}
