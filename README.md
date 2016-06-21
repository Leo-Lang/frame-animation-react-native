#frame-animation-react-native

## Installation

```
npm i --save frame-animation-react-native
```

**on Android:**

####1. `android/settings.gradle`:: Add the following snippet

```
include ':RNFA'
project(':RNFA').projectDir = file('../node_modules/frame-animation-react-native/android/frame-animation-react-native')
```

####2. `android/app/build.gradle`: Add in dependencies block.

```
compile project(':RNFA')
```

####3. in your `MainActivity` (or equivalent) the FrameAnimReactPackage needs to be added. Add the import at the top:

```
import com.leolang.frame_animation_react_native.FrameAnimReactPackage;
```

####4. In order for React Native to use the package, add it the packages inside of the class extending ReactActivity.

```
@Override
protected List<ReactPackage> getPackages() {
  return Arrays.<ReactPackage>asList(
	new MainReactPackage(),
	...
	new FrameAnimReactPackage()
  );
}

```
## Usage
###js

```
var FrameAnim = require('./node_modules/frame-animation-react-native/frameanim');


```

``` 
/* 
 * action = 'start' or 'stop'
 * frameAnimFile is the android animation xml file
 */
<FrameAnim style={{width:640,height:480}} action = 'start' frameAnimFile = 'hotel_tts_frame' oneshot = {false}></FrameAnim>


```
###android

![](https://github.com/Leo-Lang/frame-animation-react-native/raw/master/docs/usage.png)

![](https://github.com/Leo-Lang/frame-animation-react-native/raw/master/docs/usage2.png)

