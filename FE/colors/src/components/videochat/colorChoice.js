import "@easylogic/colorpicker/dist/colorpicker.css";
import ColorPickerUI from "@easylogic/colorpicker";
// Standalone
var ColorPicker = EasyLogicColorPicker.ColorPicker;
var colorpicker = ColorPickerUI.create({
  color: "blue", // init color code
  position: "inline", // default show
  container: "#color-container",
  type: "palette", // or 'sketch',  default type is 'chromedevtool'
  onChange: (color) => {
    console.log(color);
  },
});
