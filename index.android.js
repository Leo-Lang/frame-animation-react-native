/**
 * Sample React Native frame animation App
 * https://github.com/Leo-Lang/frame-animation-react-native
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Image
} from 'react-native';

var Frameanim = require('./frameanim');
class frameanim extends Component {

render() {
    return (
      <View style = {styles.demo}>
      <Frameanim style={{width:640,height:480}} action = 'start' frameAnimFile = 'hotel_tts_frame' oneshot = {false}></Frameanim>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  demo: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: 'black',
    }
});

AppRegistry.registerComponent('frameanim', () => frameanim);
