# absofttask
This test, will send an email with links to photos(GIFS) of CAT,DOG,FOX(using api) from your Gmail email, to generated email 
on https://getnada.com/. Then test will open received email on generated https://getnada.com/ and will compare received text 
to text which was send. Then test will open each link and make screen of it.

There are two tests. First using selenium to get links from API. Second using http request.

To run test you need to open repository in your IDEA
You should have ChromeDriver version downloaded appropriate to your GoogleChromeBrowser(which you can find here https://chromedriver.chromium.org/)
Then you need to fill up "config.properties" file which you can find in my repository
Also be sure that all dependencies in pom.xml file imported

And now you can run the test. You will find your 3 screens in folder you indicate
