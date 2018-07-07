package control;
import java.awt.event.ActionListener;
import vision.JanelaCliente;
import model.Dados;

public class ModelVisionRelation implements ActionListener{

  JanelaCliente t = new JanelaCliente();
  Dados d;

  public ModelVisionRelation(JanelaCliente j){
    this.j = j;

    this.j.getBtnSubmeter().addActionListener(new ActionListener(){
        public void ActionPerformed(ActionEvent arg0){
          d = new Dados(this.t.getTxtAltura.getText(), this.t.getTxtPeso.getText());
        }
    });

    this.j.getBtnLimpar().addActionListener(new ActionListener(){
        public void ActionPerformed(ActionEvent arg0){
          this.t.getTxtPeso.setText("");
          this.t.getTxtAltura.setText("");
          this.t.getLblIMC.setText("");
        }
    });
  }
  
  
}