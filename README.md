# tw2
Tribal Wars 2, https://us.tribalwars2.com is an online strategy game.  Unfortunately, there are no simple file dumps of game state available, so one must go against their undocumented web socket based API.  This project is dedicated to reverse enginerring this socket API for all to use.



## Socket Calls
Using the Developer tools in Chrome, we can see the websocket calls. Some of those calls are documented below.

| Call | example |
|--------|-------|
| Authentication/login | |
| Authentication/selectCharacter |   |
| Map/getVillagesByArea |   |
