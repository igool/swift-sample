namespace java com.igool.queue.service.thrift
	struct ItemEntry {
    			1:string acid,
    			2:i32 marklable,
    			3:string base64code
    	}

	service DistributeQueueservice {
    		 	void addQueueEntry(1:string key, 2:ItemEntry itemEntry),
    		 	list<ItemEntry> getQueueList(1:string key),
    		 	void addQueueStr(1:string key, 2:string jsonStr),
    		 	list<string> getQueueListStr(1:string key)
    	}