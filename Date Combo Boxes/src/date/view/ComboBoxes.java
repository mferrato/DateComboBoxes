package date.view;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
	 
	public class ComboBoxes {
	        
		@FXML
		private ComboBox<String> month;
		@FXML
		private ComboBox<String> day;
		@FXML
		private ComboBox<String> year;
		
		public ComboBoxes(){
		}
		
		@FXML
		private void initialize(){
			
			List<String> months = Arrays.asList(new DateFormatSymbols().getMonths());
			month.getItems().addAll(months);
			month.getItems().remove(month.getItems().size() - 1);
			month.setValue(month.getItems().get(Calendar.getInstance().get(Calendar.MONTH)));
			day.setValue(Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
			year.setValue(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
			
			for(int i= 0 ;i <= 10 ;i++){
				year.getItems().add(Integer.toString(Calendar.getInstance().get(1) + i));
			}
			for(int i = 1; i<=Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH); i++){
				day.getItems().add(Integer.toString(i));
			}
		}
		
		@FXML
		private void dateChange(){
			if(day.getValue() == null) day.setValue("1");
			
			if((year.getValue()!= null) && (month.getValue()!=null) && (day.getValue()!=null)){
				Calendar calendar = new GregorianCalendar(
						Integer.parseInt(year.getValue()),
						month.getItems().indexOf(month.getValue()),
						Integer.parseInt(day.getValue()));
				day.getItems().remove(0, day.getItems().size());
				
				for(int i = 1 ;i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
					day.getItems().add(Integer.toString(i));
				}
			}
		}
	}

