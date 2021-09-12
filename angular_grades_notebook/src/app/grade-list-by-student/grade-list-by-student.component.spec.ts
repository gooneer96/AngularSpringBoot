import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GradeListByStudentComponent } from './grade-list-by-student.component';

describe('GradeListByStudentComponent', () => {
  let component: GradeListByStudentComponent;
  let fixture: ComponentFixture<GradeListByStudentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GradeListByStudentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GradeListByStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
