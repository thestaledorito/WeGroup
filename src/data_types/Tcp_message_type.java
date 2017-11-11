package data_types;

public enum Tcp_message_type
{
	Login,
	Login_response,
	Update,
	Connection_closed,
	Message,
	List,
	Poll,
	Poll_vote,
	Other
}