public class DatenspeicherMinMaxT<T>
{
 private T min, max;
 
 public void setMax(T neuerWert)
 {
  max = neuerWert;
 }
 public void setMin(T neuerWert)
 {
  min = neuerWert;
 }
 public T getMax()
 {
  return max;
 }
 public T getMin()
 {
  return min;
 }
}