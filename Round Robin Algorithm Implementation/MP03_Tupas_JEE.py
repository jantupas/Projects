import sys
import os

class Process:
    def __init__(self, index, arrival, permaburst, burst, turnaround, waiting, time, priority, real_time, real_time_length):
        self.index = index
        self.arrival = arrival
        self.permaburst = permaburst
        self.burst = burst
        self.turnaround = turnaround
        self.waiting = waiting
        self.time = time
        self.priority = priority
        self.real_time = []
        self.real_time_length = []

def main():
    while True:
        with open('MP03 Checker.txt') as f:
            lines = f.readlines()

        num = int(lines[0].strip())
        quantum = int(lines[1].strip())

        arrivalNum = lines[2].strip().split()
        arrivalNum = [int(num) for num in arrivalNum]

        burstNum = lines[3].strip().split()
        burstNum = [int(num) for num in burstNum]

        priority = lines[4].strip().split()
        priority = [int(num) for num in priority]

        totalTurnaround = 0
        totalWaiting = 0
        currentTime = 0

        processes = []

        for i in range(num):
            procs = Process(i + 1, arrivalNum[i], burstNum[i], burstNum[i], 0, 0, 0, priority[i], 0, 0)
            processes.append(procs)

        queue = []
        bursts = []
        final_queue = []
        priorities = []
        task_width = []

        while True:
            for i in range(num):
                if processes[i].arrival <= currentTime and processes[i].burst > 0:
                    if processes[i].burst <= quantum:
                        currentTime += processes[i].burst
                        processes[i].burst = 0
                    else:
                        currentTime += quantum
                        processes[i].burst -= quantum

                    processes[i].time = currentTime
                    final_queue.append(processes[i])
                    processes[i].real_time.append(currentTime)
                    task_width.append(currentTime)

            all_done = True
            for i in range(num):
                if processes[i].burst > 0:
                    all_done = False
                    break

            if all_done:
                break

        for p in processes:
            p.turnaround = p.time - p.arrival
            p.waiting = p.turnaround - p.permaburst
            totalTurnaround += p.turnaround
            totalWaiting += p.waiting

        aveTurn = (totalTurnaround / len(processes))
        aveWait = (totalWaiting / len(processes))

        print("Programmed by: Jan Edgar E. Tupas")
        print("MP03 - Round Robin")
        print("Enter No. of Processes: {}".format(len(processes)))
        print("Quantum Time (ms) - {}".format(quantum))

        print("Arrival Time:")
        for p in processes:
            print("P{}: {}".format(p.index, p.arrival))

        print("")

        print("Burst Time:")
        for p in processes:
            print("P{}: {}".format(p.index, p.permaburst))

        print("")

        print("Priority Number:")
        for p in processes:
            print("P{}: {}".format(p.index, p.priority))

        print("")
        for p in processes:
            p.real_time_length.append(len(p.real_time))

        # Gantt chart
        num_columns = len(final_queue)
        task_data = [p.index for p in final_queue]

        row_format = "| " + " | ".join(["{:^{}}"] * num_columns) + " |"

        test_width = []
        values = []
        for data, width in zip(task_data, task_width):
            values.append("P{}".format(data))
            values.append(quantum)
            test_width.append(quantum)

        formatted_row = row_format.format(*values)

        header_row = "+-{}-+".format("-+-".join("-" * (quantum) for width in test_width))
        footer_row = "+-{}-+".format("-+-".join("-" * (quantum) for width in test_width))
        label_row = [" " + " " * (quantum) + str(width) for width in task_width]


        print("Gantt Chart")
        print(header_row)

        print(formatted_row)

        print(footer_row)

        print("0 " + "".join(label_row))

        print("\n")
        # Table
        data = []
        for i in range(len(processes)):
            p = processes[i]
            data.append(("P{}".format(p.index), p.turnaround, p.waiting))

        header = "+---------+-----------------+--------------+"
        row_format = "| {:<7} | {:^15} | {:^12} |"
        print("Table")
        print(header)
        print(row_format.format("PROCESS", "TURNAROUND TIME", "WAITING TIME"))
        print(header)

        for process, turnaround, waiting in data:
            print(row_format.format(process, turnaround, waiting))
            print(header)

        print(row_format.format("TOTAL", totalTurnaround, totalWaiting))
        print(header)
        print(row_format.format("AVERAGE", f"{aveTurn:.2f}", f"{aveWait:.2f}"))
        print(header)

        # Write the output to a text file
        file_path = "MP03 Checker.txt"

        with open(file_path, "a") as file:
            # Redirect the standard output to the file
            sys.stdout = file

            print("\nProgrammed by: Jan Edgar E. Tupas")
            print("MP03 - Round Robin")
            print("Enter No. of Processes: {}".format(len(processes)))
            print("Quantum Time (ms) - {}".format(quantum))

            print("Arrival Time:")
            for p in processes:
                print("P{}: {}".format(p.index, p.arrival))

            print("")

            print("Burst Time:")
            for p in processes:
                print("P{}: {}".format(p.index, p.permaburst))

            print("")

            print("Priority Number:")
            for p in processes:
                print("P{}: {}".format(p.index, p.priority))

            print("")

            # Gantt chart
            num_columns = len(final_queue)
            task_data = [p.index for p in final_queue]

            row_format = "| " + " | ".join(["{:^{}}"] * num_columns) + " |"

            test_width = []
            values = []
            for data, width in zip(task_data, task_width):
                values.append("P{}".format(data))
                values.append(quantum)
                test_width.append(quantum)

            formatted_row = row_format.format(*values)

            header_row = "+-{}-+".format("-+-".join("-" * (quantum) for width in test_width))
            footer_row = "+-{}-+".format("-+-".join("-" * (quantum) for width in test_width))
            label_row = [" " + " " * (quantum) + str(width) for width in task_width]

            print("Gantt Chart")
            print(header_row)

            print(formatted_row)

            print(footer_row)

            print("0 " + "".join(label_row))

            print("\n")
            # Table
            data = []
            for i in range(len(processes)):
                p = processes[i]
                data.append(("P{}".format(p.index), p.turnaround, p.waiting))

            header = "+---------+-----------------+--------------+"
            row_format = "| {:<7} | {:^15} | {:^12} |"
            print("Table")
            print(header)
            print(row_format.format("PROCESS", "TURNAROUND TIME", "WAITING TIME"))
            print(header)

            for process, turnaround, waiting in data:
                print(row_format.format(process, turnaround, waiting))
                print(header)

            print(row_format.format("TOTAL", totalTurnaround, totalWaiting))
            print(header)
            print(row_format.format("AVERAGE", f"{aveTurn:.2f}", f"{aveWait:.2f}"))
            print(header)

        sys.stdout = sys.__stdout__

        while True:
            run_again = input("Do you want to run again [y/n]: ").strip().lower()
            if run_again == 'n' or run_again == 'y':
                break
            else:
                print("Invalid input. Please enter 'y' or 'n'.")

        if run_again == 'n':
            break
        else:
            os.system('cls')

if __name__ == "__main__":
    main()
