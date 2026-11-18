# Dhruv Rathee — CloudStream 3 Plugin

A CloudStream 3 (reCloudStream) provider for the Dhruv Rathee YouTube
channel — 25 playlists, organised into topic tabs, playable in the app.

**Source:** `https://www.youtube.com/@dhruvrathee`

## Install

Add this repository URL in CloudStream (Settings → Extensions → Add Repository):

```
https://raw.githubusercontent.com/Akhilesh2412/dhruv-rathee-courses/builds/repo.json
```

Then install the **Dhruv Rathee** plugin (v1) from the repository.

## What it does

- **Home page** — one tab per topic: Current Affairs, History & Culture,
  Science & Space, Finance & Business, Education, Travel & Vlogs.
- **Playlists as courses** — 25 full YouTube playlists (1,309 videos).
  Each course shows its playlist thumbnail; every video is an episode
  with its own thumbnail and plays through CloudStream's bundled
  YouTube extractor. The list lives in `youtube_courses.json` in this
  repo (each course carries a `category`), so adding a playlist is a
  data change, not a rebuild — but a new category needs a matching tab
  in the provider code.
- **Search** — searches playlist titles and the channel name.
- **Playback** — on play, a video first tries a fresh 1080p direct link
  from the y2mate converter (fetched at that moment, because such links
  expire within minutes), then falls back to the bundled YouTube
  extractor — so a video still plays even if the converter is blocked.

## Playlists (25)

| Topic | Playlists |
|---|---|
| Current Affairs (6) | Current Affairs (India), Current Affairs (World), Indian Politics, Geopolitics, The Dhruv Rathee Show, Ground Reports |
| History & Culture (3) | History Education, Gems of India, Socio-cultural Issues |
| Science & Space (5) | Science, Space Videos, Health Education, Mystery Videos, Coronavirus Videos |
| Finance & Business (2) | Financial Education, Business Model Series |
| Education (5) | Educational Videos, Basics by Dhruv Rathee, Solutions, Exclusive Interviews with Dhruv Rathee, Bebak with Abhisar Sharma |
| Travel & Vlogs (4) | Travel & Adventure, DW Travel Videos, Dhruv Rathee Vlogs, About Me |

## Build

Pushes to `main` trigger the GitHub Actions workflow (`.github/workflows/build.yml`),
which builds the plugin and publishes it to the `builds` branch
(`repo.json`, `plugins.json`, `*.cs3`).

## Data format

`youtube_courses.json`:

```json
{"courses": [{"id", "title", "channel", "category", "description",
"thumbnail", "videoCount", "videos": [{"id", "title", "duration",
"thumbnail"}]}]}
```

- `id` is the YouTube playlist ID; `videos[].id` is the YouTube video ID.
- `category` must match one of the home-page tabs above.
- `duration` is in seconds; `thumbnail` is the `hqdefault.jpg` image.
