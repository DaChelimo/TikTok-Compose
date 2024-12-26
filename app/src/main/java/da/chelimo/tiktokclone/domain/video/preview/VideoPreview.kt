package da.chelimo.tiktokclone.domain.video.preview

data class VideoPreview(
    val id: String,
    val thumbnail: String,
    val totalPlays: Long
) {
    companion object {
        val TEST_VIDEO = VideoPreview(
            "1234",
            "https://media.licdn.com/dms/image/v2/D4D03AQEQGF0MjZQ2BQ/profile-displayphoto-shrink_200_200/profile-displayphoto-shrink_200_200/0/1731534463396?e=2147483647&v=beta&t=UvhmIgbv0wEyjRG6VOujTIEFRDIJcKM_bpgMdV1gpow",
            230
        )

        val TEST_LIST = (1..10).map { TEST_VIDEO }
    }
}