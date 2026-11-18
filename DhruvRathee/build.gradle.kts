// Dhruv Rathee — single-provider CloudStream plugin.
// Version must stay a bare integer: the CloudStream gradle plugin reads
// `project.version` with .toIntOrNull() and falls back to -1 otherwise.
version = 1

dependencies {
    // jsoup 1.18.3 is compiled against jspecify annotations (provided
    // scope), so they must be present on the compile classpath.
    implementation("org.jspecify:jspecify:1.0.0")
}

cloudstream {
    description = "Dhruv Rathee YouTube channel — 25 playlists organised into topic tabs (Current Affairs, History & Culture, Science & Space, Finance & Business, Education, Travel & Vlogs). Open a playlist to see its videos and play them in CloudStream. On play, a video first tries a fresh direct link from SnapAny, then falls back to the YouTube extractor."
    authors = listOf("Akhilesh2412")

    /**
     * Status int as one of the following:
     * 0: Down
     * 1: Ok
     * 2: Slow
     * 3: Beta-only
     **/
    status = 1

    tvTypes = listOf("Others")
    language = "en"

    // No resources are required (no custom fragment/settings UI).
    requiresResources = false
}
