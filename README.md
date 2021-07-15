# cvs-auto-mobile-app
This is the the project for creating and managing the IOS application automated tests


## Getting Started

These instructions will get you up and running with Appium for IOS and the automation framework. 

### Prerequisites

 - Have brew installed: https://brew.sh/
 - Install Node in Terminal:
 
 ```
$ brew install node
 ```

 - Have Xcode installed through the Mac's app store.
 - Make sure you have an Apple Developer account (preferably provided by DevOps).
 - A real IOS device with the IOS app installed - iPhone 8 Plus
 - Make sure the IOS device has "Enable UI Automation" switched on
 
 ```
 Settings > Developer > Enable UI Automation
 ```

### Setting Up Appium

 1. Download and install Appium Desktop Client https://github.com/appium/appium-desktop/releases/

 * [appium-desktop](https://github.com/appium/appium-desktop/releases/)
 
 2. Install appium server
 ```
 $ npm install -g appium
 (you can install specific version with appium@x.x.x (e.g $ npm install -g appium@1.9.1)  
 ```
 
 3. Install carthage
 ```
 $ brew install carthage
 ```
 
 4. Install libimobiledevice

 ```
 $ brew install libimobiledevice
 ```
 
 5. Install ios-deploy

 ```
 Using brew:
 $ brew install libimobiledevice
  
 Using npm:
 $ npm install -g ios-deploy
 ```
  
 6. Retrieve the directory where Appium server is installed on step 2. To set up the appium desktop jump to step 8.
  
 ```
 $ which appium
 /path/to/appium
 ```
    
 7. Go to the appium path
 ```
 $ cd <path/to/appium>
 ```
 8. Go to Appium-desktop path (Only for Appium desktop)
 ```
 $ cd //Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/
 ```
  
 9. Create WebDriverAgent bundle
 ```
 $ mkdir -p Resources/WebDriverAgent.bundle
 ```
 
 10. Run script to fetch dependencies:
 ```
 $ ./Scripts/bootstrap.sh -d
 ```
 
 11. Open the finder in the current directory
 ```
 $ open .
 ```
 
 12. Open WebDriverAgent.xcodeproj with Xcode
 
 13. Make sure to add the IOS developer account to Xcode
 ```
 Xcode >  Preferences... > Accounts
 Click "+" > Apple ID > Continue > add the account - ONLY IF THE REQUIRED ACCOUNT IS NOT LISTED 
 ```
 
 14. Sign WebDriverAgentLib and WebDriverAgentRunner:
 ```
 Target WebDriverAgentLib > General
 1. Check Automatically manage signing
 2. Select Team
 3. Go to Build Settings and edit the "Product Bundle Identifier" add a custom name between facebook and WebDriverAgentLib (e.g. com.facebook.randomTEXT123.WebDriverAgentLibe)
 4. Go back to General to see if everything is ok
 5. Repeat steps 1-3 for WebDriverAgentRunner (use the same bundle identifier)
 ```
 
 15. Connect the IOS device to the Mac and keep it unlocked
 
 16. Go back to the Terminal and get the device udid:
 ```
 $ idevice_id -l
 udid will be displayed
 ``` 
 
 17. Copy udid and run
 ```
 $ xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id=<udid>' test
 ```
 
 18. The build will fail. Go to the IOS device and trust the developer account
 ```
 Settings > General > Device Management > the developer account used > trust
 ```
 
 19. Re-run step 17, wait until the script stops on Set-up
 
 20. Interrupt the terminal (Ctrl + c)


## Running Appium
 - For server: Open Terminal -> $ appium
 - For desktop: Open appium-desktop client

## Setting up the framework

### Git Hooks

Please set up the following prepush git hook in .git/hooks/pre-push

```
#!/bin/sh
npm run prepush && git log -p | scanrepo

```

#### Security

Please install and run the following securiy programs as part of your testing process:

https://github.com/awslabs/git-secrets

- After installing, do a one-time set up with `git secrets --register-aws`. Run with `git secrets --scan`.

https://github.com/UKHomeOffice/repo-security-scanner

- After installing, run with `git log -p | scanrepo`.

These will be run as part of prepush so please make sure you set up the git hook above so you don't accidentally introduce any new security vulnerabilities.

### Config File

In the project structure create the file: `cvs-auto-svc/src/main/resources/conf/environment.properties` 

(Do NOT add it to Git versioning !)
The file should contain:

```properties
type=localBrowserstack
browserstack.username=<browserstack_username>
browserstack.password=<browserstack_password>
browserstack.hostname=hub-cloud.browserstack.com
browserstack.os.version=12
browserstack.device=iPhone 8 Plus
browserstack.local=false
browserstack.real.mobile=true
browserstack.app=bs://<browserstack_app_id>
browserstack.appium.version=1.18.0
browserstack.video.enabled=true
browserstack.timezone=UTC
browserstack.idle.timeout=150
browserstack.network.logs=true
browserstack.project.name=local
browserstack.build.name=local
browserstack.gpsLocation=51.5074,0.1278
app.token.url.v2=https://login.microsoftonline.com/<azure_app_id>/oauth2/v2.0/token
app.client.id.v2=<azure_client_id>
app.client.secret.v2=<azure_client_secret>
app.username=<app_username>
app.password=<app_userpass>
app.token.url=https://login.microsoftonline.com/<azure_app_id>/oauth2/token
app.client.id=<azure_client_id>
base.path.url=<test_environment_url>
waitForQuiescence=true
local.name=<your_name>
automationName=XCUITest
parallel.consumers=1
app.users=<app_username><staff_id><password>
```
#### where:
   - **browserstack_app_id** can be obtain via: [DEVELOP_DISPLAY_BROWSERSTACK_ID](https://jenkins.cvs.dvsacloud.uk/job/UPDATE__DEVELOP/job/job_develop_display_browserstack_id/) or [FEATURE_DISPLAY_BROWSERSTACK_ID](https://jenkins.cvs.dvsacloud.uk/job/UPDATE__BRANCH/job/job_feature_display_browserstack_id/) Jenkins jobs
   - **azure_app_id** and **azure_client_id** are provided by the devOps team
   - **app.users** contains the value for the testerStaffId. This is based on the spike which concluded that it will require 3 API calls to get the testerStaffId while generating the Bearer Token and authenticating the API calls. It is not possible to run the tests without this value and have an impact on the regression suite

## Running locally

Running can be triggered from IntelliJ or via mvn command in the terminal

## Running in CI

In Jenkins tests may be executed against either a branch or develop:

- [UPDATE__BRANCH](https://jenkins.cvs.dvsacloud.uk/job/UPDATE__BRANCH/job/job_feature_test_mobile/)
- [UPDATE__DEVELOP](https://jenkins.cvs.dvsacloud.uk/job/UPDATE__DEVELOP/job/job_develop_test_mobile/)

Execution is triggered via "Build with Parameters" job with the options to select the test group from the 'MVN_TAG' dropdown.

A full data reseed and the number of parallel threads are also optional

 
## Contributors

 - Teodor Cosmin Alexandru - @teoAlexandru
 - Laurentiu George Vasile - @lgvasile
 - Bogdan Catalin Florea - @bflorea
 - Dragos Panzaru - @dpanzaru
 - Deepika Singh - @deepikasingh