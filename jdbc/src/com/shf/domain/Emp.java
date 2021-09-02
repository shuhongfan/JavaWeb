package com.shf.domain;

import java.util.Date;

public class Emp {
  private int id;
  private String ename;
  private int job_id;
  private int mgr;
  private Date join;
  private double salary;
  private int dept_id;

  public Emp(int id, String ename, int job_id, int mgr, Date join, double salary, int dept_id) {
    this.id = id;
    this.ename = ename;
    this.job_id = job_id;
    this.mgr = mgr;
    this.join = join;
    this.salary = salary;
    this.dept_id = dept_id;
  }

  public Emp() {
  }

  @Override
  public String toString() {
    return "Emp{" +
            "id=" + id +
            ", ename='" + ename + '\'' +
            ", job_id=" + job_id +
            ", mgr=" + mgr +
            ", join=" + join +
            ", salary=" + salary +
            ", dept_id=" + dept_id +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public int getJob_id() {
    return job_id;
  }

  public void setJob_id(int job_id) {
    this.job_id = job_id;
  }

  public int getMgr() {
    return mgr;
  }

  public void setMgr(int mgr) {
    this.mgr = mgr;
  }

  public Date getJoin() {
    return join;
  }

  public void setJoin(Date join) {
    this.join = join;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public int getDept_id() {
    return dept_id;
  }

  public void setDept_id(int dept_id) {
    this.dept_id = dept_id;
  }
}
