# Audio Library
#### Introduction
This Java project implements an **Audio Library** that allows users with different roles to perform various operations related to managing songs and playlists. The system supports three types of roles: Anonymous, Administrator, and Authenticated.

#### Roles
**Anonymous**: Users who haven't logged in to the system.
**Administrator**: Users with administrative privileges.
**Authenticated**: Logged-in users who are authenticated.
#### Commands
	help: Returns the available commands based on the user's role.
	login username password: Logs in the anonymous user.
	logout: Logs out the authenticated user.
	register username password: Registers a new user.
	create song "name" "artist" year: Creates a new song.
	create playlist "name": Creates a new playlist.
	reset: Resets the database.
	read: Reads songs from the .csv file.
	promote: Promotes a user to admin.
	add byname "playlistName" [song_id]: Adds a song or a list of songs to a playlist by name.
	add byid playlist_id [song_id]: Adds a song or a list of songs to a playlist by ID.
	list playlists: Displays all playlists paginated.
	export playlist "playlistName": Exports all songs from a playlist to a JSON file.
	search searchCriteria "criteria": Displays paginated songs based on the search criteria.
	audit username: Displays paginated commands used by a specific user.
#### Specifications
The application uses a **PostgreSQL** database to store all created objects (users, songs, playlists).
It automatically backs up the data at the beginning and remembers all previous data after stopping the application.
