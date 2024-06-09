package api.endpoints;

/*
Create user(post): http://localhost:3000/user
Get user (get): http://localhost:3000/user/{id}
update user (PUT): http://localhost:3000/user/{id}


*/
public class Routes {
	public static String base_url= "http://localhost:3000";
	
	//user module
	public static String post_url= base_url+"/user";
	public static String get_url= base_url+"/user/{id}";
	public static String put_url= base_url+"/user/{id}";
	public static String patch_url= base_url+"/user/{id}";
	public static String delete_url= base_url+"/user/{id}";

}
