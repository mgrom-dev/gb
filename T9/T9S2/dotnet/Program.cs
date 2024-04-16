// Добавление пакета для теста производительности
// dotnet add package BenchmarkDotNet
using BenchmarkDotNet.Running;

namespace ArraySortTests {
    class Program {
        static void Main(string[] args) {
            BenchmarkSwitcher
                .FromAssembly(typeof(Program).Assembly)
                .Run(args, new BenchmarkDotNet.Configs.DebugInProcessConfig());
                
            BenchmarkRunner.Run<SortTests>();
        }
    }
}
