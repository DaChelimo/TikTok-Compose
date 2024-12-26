package da.chelimo.tiktokclone.domain.user

/**
 * Data class for the user's account
 */
data class User(
    val userName: String,
    val name: String,
    val accountCreated: Long,
    val followerCount: Int,
    val followingCount: Int,
    val likeCount: Int
)
