package model;

import java.awt.event.ActionListener;
import vision.JanelaCliente;
import model.Dados;

public class ModelVisionRelation implements ActionListener{

  JanelaCliente t = new JanelaCliente();
  Dados d;

  public ModelVisionRelation(JanelaCliente j, Dados d){
    this.j = j;
    this.d = d;

    this.j.getBtnSubmeter().addActionListener(new ActionListener(){
        public void ActionPerformed(ActionEvent arg0){
          d = new Dados(this.t.getTxtAltura.getText(), this.t.getTxtPeso.getText());
          d.imc = fazImc(d);
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

  public double fazImc(Dados d){
    imc = d.peso / (Math.pow(2, d.altura));
    return imc;
  }
}