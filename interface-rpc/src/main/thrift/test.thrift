	namespace java com.igool.file.service.test.thrift

	enum Status {
    			NORMAL = 0,
    			BLOCKED = 1
    	}

    	struct Account {
    			1:i32 id,
    			2:string name
    	}
    	struct User {
    			1:i32 id,
    			2:string name,
    			3:bool sex,
    			4:Status status,
    			5:list<i64> ids,
    			6:Account account
    	}

    	service ICommonUserService {
    		 	map<string, list<User>> getUsersByName(1:list<string> names),
    		 	User login(1:i32 id, 2:string name),
    		 	list<string> testCase1(1:map<i32, string> num1, 2:list<User> num2, 3:list<string> num3, 4:i64 num4, 5:string num5),
    		 	map<i64, list<i64>> getGroupUsers(1:list<string> names, 2:list<User> userList, 3:list<i64> lns, 4:i64 ll),
    		 	User getUserById(1:i64 id),
    		 	bool saveUser(1:User user),
    		 	map<i64, User> getUserByIds(1:list<User> ids),
    		 	list<User> getUserIds(1:i64 id)
    	}