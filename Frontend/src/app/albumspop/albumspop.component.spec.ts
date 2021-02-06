import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumspopComponent } from './albumspop.component';

describe('AlbumspopComponent', () => {
  let component: AlbumspopComponent;
  let fixture: ComponentFixture<AlbumspopComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlbumspopComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlbumspopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
