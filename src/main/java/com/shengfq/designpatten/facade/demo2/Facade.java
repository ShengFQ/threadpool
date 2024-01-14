package com.shengfq.designpatten.facade.demo2;

/**
 * ClassName: Facade Description: TODO
 *
 * @author shengfq
 * @date: 2024/1/14 5:21 下午
 */
public class Facade {
  private final Patient patient;

  public Facade(final Patient patient) {
    this.patient = patient;
  }

  void dispose() {
    final Registry registry = new Registry();
    registry.dispose(this.patient);
    final Doctor doctor = new Doctor();
    doctor.dispose(this.patient);
    final Pharmacy pharmacy = new Pharmacy();
    pharmacy.dispose(this.patient);
  }
}
