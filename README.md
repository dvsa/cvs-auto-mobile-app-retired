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

TBD

 
## Contributors

 - Teodor Cosmin Alexandru - @teoAlexandru
 - Laurentiu George Vasile - @lgvasile
