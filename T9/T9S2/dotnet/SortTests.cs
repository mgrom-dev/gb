using BenchmarkDotNet.Attributes;

namespace ArraySortTests {
    [MemoryDiagnoser]
    public class SortTests{
        private static int[] array = ArrayUtils.prepareArray(50000);

        [Benchmark]
        public void DirectSortTest() {
            SortUtils.directSort((int[])array.Clone());
        }

        [Benchmark]
        public void QuickSortTest() {
            SortUtils.quickSort((int[])array.Clone());
        }
    }
}