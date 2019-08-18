public class DatenspeicherPaar<T, T2> extends Datenspeicher<T>
{
 private T2 wert2;
 
 void setPaar(T neuerWert1, T2 neuerWert2)
 {
  super.setWert(neuerWert1);
  wert2 = neuerWert2;
 }
 
 T getWert1()
 {
  return super.getWert();
 }
 T2 getWert2()
 {
  return wert2;
 }
}
