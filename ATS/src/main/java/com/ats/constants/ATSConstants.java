package com.ats.constants;

public class ATSConstants {

	// USER MODULE

	// User Module views
	public static final String USER_VIEW = "user";
	public static final String USER_SIGN_UP = "userSignUp";
	public static final String USER_LOG_IN = "userLogIn";
	public static final String USER_UNLOCK = "userUnLock";
	public static final String USER_FORGOT = "userForgotPwd";
	public static final String EDIT_USER = "editUser";

	// url
	public static final String USER_UNLOCK_URL = "userUnLock";

	// ADMIN MODULE

	// Admin module views
	public static final String ADMIN_VIEW = "admin";
	public static final String ADMIN_SIGN_UP = "adminSignUp";
	public static final String ADMIN_UN_LOCK = "adminUnLock";
	public static final String EDIT_AGENCY = "editAgency";

	// url
	public static final String ADMIN_UNLOCK_URL = "adminUnLock";

	// COMMON FOR ADMIN MODULE AND USER MODULE

	public static final String UNLOCK_FAILURE = "Your Account Is Locked Mode.Can You Please Unlock Your Account";
	public static final String LOGIN_FORGT_PWD = "Your Password Has Been Sent To Your Mail.";
	public static final String REG_SUCCESS = "Account Registration Is Almost Successfull...! Can You Please Check Your Mail And UnLock Your Account.";
	public static final String LOGIN_FILURE = "Your Credentials are Wrong...can you please verify once...!";
	public static final String TEMP_PWD_INCORRECT = "Your Temporary Password is Not Correct..! Can you please Verify Once";
	public static final String UNLOCKED_SUCCESS = "Thank you.Your Account Has Been Unlokced. You Can SignIn..!";
	public static final String LOGIN_WRONG_EMAIL = "The email address or password that you've entered doesn't match any account. Sign up for an account. ";
	public static final String REG_FAIL = "registraction is failure";
	public static final String IN_ACTIVE = "Your Account is De-Active Mode.Please contact your Admin";
	public static final String UPDATED = "Your Records are Updated";
	public static final String NOT_UPDATED = "Your Records are not Updated";

	// status
	public static final String LOCKED = "LOCKED";
	public static final String UN_LOCKED = "UN_LOCKED";
	// roles
	public static final String USER = "USER";
	public static final String ADMIN = "ADMIN";
	public static final String AGENCY = "AGENCY";

	// tag module

	public static final String RECHARGE_VIEW = "recharge";
	public static final String PURCHASETAG_VIEW = "purchaseTag";
	public static final String SEARCH_VEH_REGNO_VIEW = "searchVehRegNo";
	public static final String VIEWTAGS_VIEW = "viewTags";
	public static final String UPDATE_RECHARGE = "updateRecharge";

	public static final String TAG_MSG = "your tag is not expired, already you have a tag please use existing tag.If existing tag is damaged please contact our customer service.";
	public static final String TAG_PURCHAGE_SUCCESS = "your tag purchage is successfully completed.now you can recharge balance for your tag";
	public static final String TAG_PURCHAGE_FAILURE = "your tag purchage is failed";
	public static final String TAG_RECHARGE_SUCCESS = "Recharge is Successful.";
	public static final String TAG_UPDATE_RECHARGE_FAILURE = "Recharge is failed because your tag is not Active.";
	public static final String TAG_RECHARGE_FAILURE = "Recharge is Failed.Try one more time.";
	public static final String TAG_REGID_WRONG="Enter Correct TagRegId.";
	
	public static final String TAG_EXPIRED = "EXPIRED";
	public static final String TAG_RENEW = "RENEW";
	public static final String TAG_VALID = "VALID";
	public static final String NO_TAGS="You Don't Have Any Tags";

	// tagTx module
	public static final String TAG_TX_DTLS_VIEW = "tagTransactionsDetails";
	public static final String TAG_NO_TX="There Is No Transactions Are Done Yet";
	
}
