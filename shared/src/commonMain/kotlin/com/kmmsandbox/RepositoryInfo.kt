import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepositoryInfo(
    @SerialName("name")
    val name: String,
    val owner: RepositoryOwner,
    @SerialName("html_url")
    val url: String
)

@Serializable
data class RepositoryOwner(
    val login: String,
    @SerialName("avatar_url")
    val avatar: String
)