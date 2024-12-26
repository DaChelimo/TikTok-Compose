package da.chelimo.tiktokclone.domain.video

data class Post(
    val id: String,
    val thumbnail: String,
    val videoUrl: String,
    val timeUploaded: Long,
    val caption: String,
    val likes: Int,
    val comments: Int,
    val shares: Int
)
