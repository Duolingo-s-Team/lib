package interfaces;

import java.util.List;

import models.Following;

public interface IFollowing {

	public List<Following> getAllFollowingUsers();
	
	public Following getFollowingById(long following_id);
	
	public boolean deleteFollowing(Following following);
	
	public Following insertFollowing(Following following);
	
	public Following updateFollowing(Following following);
}
