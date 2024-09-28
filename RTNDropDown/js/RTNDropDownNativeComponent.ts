import type {ViewProps} from 'ViewPropTypes';
import type {HostComponent} from 'react-native';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import {DirectEventHandler} from 'react-native/Libraries/Types/CodegenTypes';

type Event = Readonly<{
  value: string;
}>;

export interface NativeProps extends ViewProps {
  values: ReadonlyArray<string>;
  onSelectionChnaged?: DirectEventHandler<Event>; //Event name should start with on
}

export default codegenNativeComponent<NativeProps>(
  'RTNDropDown',
) as HostComponent<NativeProps>;
