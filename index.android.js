/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Image
} from 'react-native';


 var RKframeanim = require('./frameanim');
var frameindex = 47;
class frameanim extends Component {
  constructor(props){
     super(props);
    this.state = {
        // imagePath:'file:///data/image/frameanim0.jpg'
        // imagePath:'file:///data/image/0_000'+frameindex+'.png'
    };
  }

  render() {
    // console.log("langneng render this.state.imagePath:"+this.state.imagePath);
    return (
      // <View style = {
      //                 styles.demo
      //             }>
      // <Image style={{width:480,height:480}} source={{uri:this.state.imagePath}}/>
      // </View>
      <View style = {
            styles.demo
        }>
      <RKframeanim style={{width:640,height:480}} action = 'start' frameAnimFile = 'hotel_tts_frame' oneshot = {false}></RKframeanim>
      </View>
    );
  }
  shouldComponentUpdate(nextProps,nextState){
    console.log("langneng shouldComponentUpdate");
    return true;
  }

  componentWillUpdate(){
    console.log("langneng componentWillUpdate");
  }

  componentDidMount(){

      // requestAnimationFrame(this.frameAnimation.bind(this));
  }

  frameAnimation(){
      frameindex++;
      console.log("langneng invoke requestAnimationFrame");
      // this.state.imagePath = 'file:///data/image/frameanim1.jpg';
      if(frameindex>125) {
        frameindex = 48;
      }
      if(frameindex<100){
      this.setState({
        // imagePath:'file:///data/image/frameanim'+frameindex+'.jpg'
           imagePath:'file:///data/image/0_000'+frameindex+'.png'
      });
    }else{
      this.setState({
        // imagePath:'file:///data/image/frameanim'+frameindex+'.jpg'
           imagePath:'file:///data/image/0_00'+frameindex+'.png'
      });
    }
      console.log("langneng set this.state.imagePath:"+this.state.imagePath);

      // setTimeout(()=>{requestAnimationFrame(this.frameAnimation.bind(this));},500);
      requestAnimationFrame(this.frameAnimation.bind(this));
  }
}


const styles = StyleSheet.create({
  demo: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: 'black',
    },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('frameanim', () => frameanim);
