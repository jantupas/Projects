import sys
import os

class Process:
    def __init__(self, index, arrival, permaburst, burst, turnaround, waiting, time, priority):
        self.index = index
        self.arrival = arrival
        self.permaburst = permaburst
        self.burst = burst
        self.turnaround = turnaround
        self.waiting = waiting
        self.time = time
        self.priority = priority

def main():
    while True:
        with open('MP02_Tupas_JEE.txt') as f:
            lines = f.readlines()

        num = int(lines[0].strip())

        arrivalNum = lines[1].strip().split()
        arrivalNum = [int(num) for num in arrivalNum]
        arrivalCheck = list(arrivalNum)

        burstNum = lines[2].strip().split()
        burstNum = [int(num) for num in burstNum]

        priority = lines[3].strip().split()
        priority = [int(num) for num in priority]

        totalTurnaround = 0
        totalWaiting = 0
        currentTime = 0

        processes = []

        for i in range(num):
            procs = Process(i + 1, arrivalNum[i], burstNum[i], burstNum[i], 0, 0, 0, priority[i])
            processes.append(procs)

        queue = []
        bursts = []
        final_queue = []
        priorities = []

        while True:
            pIndex = arrivalNum.index(min(arrivalCheck))
            if processes[pIndex].arrival == currentTime:
                while True:
                    if processes[pIndex].burst == 0:
                        processes[pIndex].time = currentTime
                        final_queue.append(processes[pIndex])
                        arrivalCheck.remove(arrivalNum[pIndex])
                        if not queue:
                            break
                        else:
                            pIndex = queue[priorities.index(min(priorities))]
                            queue.remove(pIndex)
                            priorities.remove(min(priorities))

                    if queue:
                        for p in queue:
                            processes[p].waiting += 1
                    processes[pIndex].burst -= 1
                    currentTime += 1
                    if currentTime in arrivalNum:
                        nIndex = arrivalNum.index(currentTime)
                        queue.append(nIndex)
                        bursts.append(processes[nIndex].burst)
                        priorities.append(processes[nIndex].priority)

            else:
                currentTime += 1
            if not arrivalCheck:
                break

        for p in processes:
            p.turnaround = p.waiting + p.permaburst
            totalTurnaround += p.turnaround
            totalWaiting += p.waiting

        aveTurn = (totalTurnaround / len(processes))
        aveWait = (totalWaiting / len(processes))

        print("Programmed by: Jan Edgar E. Tupas")
        print("MP02 - PRIORITY Non-Preemptive")
        print("Enter No. of Processes: {}".format(len(processes)))

        print("Arrival Time:")
        for p in processes:
            print("P{}: {}".format(p.index, p.arrival))

        print("\n")

        print("Burst Time:")
        for p in processes:
            print("P{}: {}".format(p.index, p.permaburst))

        print("\n")

        print("Priority Number:")
        for p in processes:
            print("P{}: {}".format(p.index, p.priority))

        print("\n")

        # Gantt chart
        num_columns = len(final_queue)
        task_data = [p.index for p in final_queue]
        task_width = [p.time for p in final_queue]

        row_format = "| " + " | ".join(["{:^{}}"] * num_columns) + " |"

        test_width = []
        values = []
        for data, width in zip(task_data, task_width):
            values.append("P{}".format(data))
            values.append(width // 4)
            test_width.append(width // 4)

        formatted_row = row_format.format(*values)

        header_row = "+-{}-+".format("-+-".join("-" * (width) for width in test_width))
        footer_row = "+-{}-+".format("-+-".join("-" * (width) for width in test_width))
        label_row = [" " + " " * (width // 4) + str(width) for width in task_width]

        print("Gantt Chart")
        print(header_row)

        print(formatted_row)

        print(footer_row)

        print("0  " + "".join(label_row))

        print("\n")
        # Table
        data = []
        for i in range(len(final_queue)):
            p = final_queue[i]  # Subtract 1 because the index is 1-based
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
        file_path = "MP02_Tupas_JEE.txt"

        with open(file_path, "a") as file:
            # Redirect the standard output to the file
            sys.stdout = file

            print("\nProgrammed by: Jan Edgar E. Tupas")
            print("MP02 - PRIORITY Non-Preemptive")
            print("Enter No. of Processes: {}".format(len(processes)))

            print("Arrival Time:")
            for p in processes:
                print("P{}: {}".format(p.index, p.arrival))

            print("\n")

            print("Burst Time:")
            for p in processes:
                print("P{}: {}".format(p.index, p.permaburst))

            print("\n")

            print("Priority Number:")
            for p in processes:
                print("P{}: {}".format(p.index, p.priority))

            print("\n")

            # Gantt chart
            num_columns = len(final_queue)
            task_data = [p.index for p in final_queue]
            task_width = [p.time for p in final_queue]

            row_format = "| " + " | ".join(["{:^{}}"] * num_columns) + " |"

            test_width = []
            values = []
            for data, width in zip(task_data, task_width):
                values.append("P{}".format(data))
                values.append(width // 4)
                test_width.append(width // 4)

            formatted_row = row_format.format(*values)

            header_row = "+-{}-+".format("-+-".join("-" * (width) for width in test_width))
            footer_row = "+-{}-+".format("-+-".join("-" * (width) for width in test_width))
            label_row = [" " + " " * (width // 4) + str(width) for width in task_width]

            print("Gantt Chart")
            print(header_row)

            print(formatted_row)

            print(footer_row)

            print("0  " + "".join(label_row))

            print("\n")
            # Table
            data = []
            for i in range(len(final_queue)):
                p = final_queue[i]  # Subtract 1 because the index is 1-based
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
