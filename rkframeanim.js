
import { PropTypes } from 'react';
import { requireNativeComponent, View } from 'react-native';

var iface = {
    name:'RKframeanim',
    propTypes:{
      ...View.propTypes,
      action : PropTypes.string,
      frameAnimFile : PropTypes.string,
      oneshot : PropTypes.bool
    },
};
module.exports = requireNativeComponent('RKFrameAnimView',iface);
