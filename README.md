# OctopusChallenge

I used MVVM Archiecture pattern as it's the one I enjoy using the most.

I used retofit to handle any network api calls as it's the library I have the most comfort using. I had 3 end points:

One to list all breeds provided by backend called "getAllBreeds"
One to list breed info based on clicked breed item on the main activity/interface called "getBreedInfo"
One to display all the related images based on the breed id provided by the main activity called "getBreedImage" this should be plural

Regarding UI/UX i am not too strong on this point as i usually rely on the design team for this. I also wasted a bit of time on the second end point due to a misunderstanding
of the json response, it was  a simple error that i spent too much time on.

I was thinking about using Koin for Dependancy injection but i didn't get around to it.

Lastly i also wanted to take a TDD approach but i may have ended up not finishing the entire challenge

