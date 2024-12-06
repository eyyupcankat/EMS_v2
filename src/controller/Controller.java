package controller;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import routing.Routing;
import personel.Personel;

public class Controller {
	@FXML
	public static Button infoButon;
	@FXML
	public static Button guncelleButon;
	@FXML
	public static Button ekleButon;
	@FXML
	private TextField aramaTextField;
	@FXML
	public TableView<Personel> tableView;
	@FXML
	private TableColumn<Personel,Double> personelNoColumn;
	@FXML
	private TableColumn<Personel, String> isimColumn;
	@FXML
	private TableColumn<Personel, String> soyisimColumn;
	@FXML
	private TableColumn<Personel, String> pozisyonColumn;
	@FXML
	private TableColumn<Personel, Integer> yasColumn;
	@FXML
	private TableColumn<Personel, Void> actionColumn;
	@FXML
	public static ObservableList<Personel> personelList = FXCollections.observableArrayList();
	
	@FXML
	public void initialize() {
	personelNoColumn.setCellValueFactory(new PropertyValueFactory<Personel,Double>("personelNo"));
    isimColumn.setCellValueFactory(new PropertyValueFactory<Personel,String>("isim"));
    soyisimColumn.setCellValueFactory(new PropertyValueFactory<Personel,String>("soyisim"));
    pozisyonColumn.setCellValueFactory(new PropertyValueFactory<Personel,String>("pozisyon"));
    yasColumn.setCellValueFactory(new PropertyValueFactory<Personel,Integer>("yas"));
    
    tabloyaButonEkle();
  
    tableView.setItems(personelList);//tableView a personelleri ekleme
    
	}
	
	private void tabloyaButonEkle() {
	    Callback<TableColumn<Personel, Void>, TableCell<Personel, Void>> cellFactory = new Callback<>() {
	        @Override
	        public TableCell<Personel, Void> call(final TableColumn<Personel, Void> param) {
	            return new TableCell<>() {

	                private final Button deleteButton = new Button("Sil");
	                private final Button editButton = new Button("Düzenle");
	                private final HBox hbox = new HBox(10, deleteButton, editButton); // Butonları yatay hizala

	                {
	                    // Sil butonu işlemleri
	                    deleteButton.setOnAction(event -> {
	                        Personel personel = getTableView().getItems().get(getIndex());
	                        getTableView().getItems().remove(personel);
	                        System.out.println("Personel silindi: " + personel.getIsim());
	                    });

	                    // Düzenle butonu işlemleri
	                    editButton.setOnAction(event -> {
	                        Personel personel = getTableView().getItems().get(getIndex());
	                        System.out.println("Düzenlenecek personel: " + personel.getIsim());
	                        // Burada düzenleme işlemini gerçekleştirin
	                    });
	                }

	                @Override
	                protected void updateItem(Void item, boolean empty) {
	                    super.updateItem(item, empty);
	                    if (empty) {
	                        setGraphic(null);
	                    } else {
	                        setGraphic(hbox); // Hücreye HBox (butonlar) ekle
	                    }
	                }
	            };
	        }
	    };

	    actionColumn.setCellFactory(cellFactory);
	}
	
	
	
	
	@FXML
	public  void ekleButonKod() throws IOException {
		Routing.sayfaAc("ekleSayfasi", "Yeni Personel Ekleme", false);
	}
	@FXML
	public  void guncelleButonKod() throws IOException {
		Routing.sayfaAc("guncellemeSayfasi", "Personel Bilgilerini Güncelleme", false);
	}
	@FXML
	public  void infoButonKod() throws IOException {
		Routing.sayfaAc("infoSayfasi", "Ayrıntılı Personel Bilgisi", false);
	}
	@FXML
	public void aramaTextFieldKod() {
		//sorgulama işlemi yapılacak
	}


}
