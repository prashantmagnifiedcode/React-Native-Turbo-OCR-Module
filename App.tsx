/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */
import React from 'react';
import { View } from 'react-native';
import type {Node} from 'react';
import RTNCenteredText from 'rtn-centered-text/js/RTNCenteredTextNativeComponent';
import RTNDropDown from 'rtn-drop-down/js/RTNDropDownNativeComponent';

const App: () => Node = () => {
  return (
    <>
    <RTNCenteredText
      text="Hello World!"
      style={{width: '100%', height: 30}}
    />
    <View style={{marginVertical:20}}>

     <RTNDropDown
        values={['First', 'Second', 'Third', 'Fourth']}
        onSelectionChnaged={value => {
          console.log(value.nativeEvent.value);
        }}
        style={{width: 300, height: 80}}
      />
    </View>
    </>
  );
};
export default App;