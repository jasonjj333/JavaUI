# Item Generator Test

## Purpose: 
A java program using Swing that will create a GUI for Argo Data's Item Generator program.

## How to run:
Build and run **UITest.java** as it is the main Runner for UIFramework3.java. UIFramework.java was an initial attempt and will be deleted
or renamed. UIFramework2.java previously created the UI. UIFramework3.java is an update currently in work to use custom icons and layout 
currently creates the UI.

## What is implemented:
- **Output location** combo box created to select local/database location. File Chooser opens to
current directory when local is selected and allows user to select desired directory. 
- **Cycle Number** check box and text field created. Text field can only be edited when check box is 
selected.
- **Max Items** check box and text field created. Text field can only be edited when check box is 
selected.
- **AIF Debits Only** check box created.
- **Execute** Button created. Prints information on output location, cycle number, max items,
and aif debits only if selected. 
- Return the correct String of the desired cmd command when execute button is pressed.
- Added more testing to catch most user error on current features.
- Changed to null layout and added custom icons
- **All buttons currently validated for error**
- **Minimize and Exit Buttons** Created and functional
- **Draggable Window** Window can now be moved by holding top of frame with cursor and dragging. 
- **Rounded Border** added and colors changed to give more modern theme easier on eyes
## What to work on: 
- Make an executable for this program.
- Add remaining selection features when given. 
- find way to import file and image folders to jar file
- create settings so user can change and save theme or create their own color scheme
- change argo image to shapes created in swing (and change to different seeable color based on user selection)
