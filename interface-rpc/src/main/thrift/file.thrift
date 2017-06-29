namespace java com.igool.file.service.thrift
	service FileService {
		 	bool deleteFile(1:string filePath, 2:bool isPub),
            string storeFile(1:string fileName, 2:binary fileSource, 3:bool isPub)
	}