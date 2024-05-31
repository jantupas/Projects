import sys
import os


class Process:
    def __init__(self, index, arrival, permaburst, burst, turnaround, waiting, time, prio, algo_prio, time_finished):
        self.index = index
        self.arrival = arrival
        self.permaburst = permaburst
        self.burst = burst
        self.turnaround = turnaround
        self.waiting = waiting
        self.time = time
        self.prio = prio
        self.algo_prio = algo_prio
        self.time_finished = time_finished


def main():
    while True:
        with open('MP04 Checker.txt') as f:
            lines = f.readlines()

            num = int(lines[0].strip())

            arrivalNum = lines[1].strip().split()

            arrivalNum = [int(num) for num in arrivalNum]

            burstNum = lines[2].strip().split()
            burstNum = [int(num) for num in burstNum]

            priority = lines[3].strip().split()
            priority = [int(num) for num in priority]

            algo_state = lines[4].strip().split()
            algo_state = [int(num) for num in algo_state]

            fg_num = int(lines[5].strip())
            bg_num = int(lines[6].strip())

            currentTime = 0
            processes = []
            r_queue_1 = []
            r_queue_2 = []
            pp_queue = []
            final_queue = []
            task_width = []
            p_count = 0
            total_turn = 0
            total_wait = 0
            ave_turn = 0
            ave_wait = 0
            current_p = None

            for i in range(num):
                procs = Process(i + 1, arrivalNum[i], burstNum[i], burstNum[i], 0, 0, 0, priority[i], algo_state[i], 0)
                processes.append(procs)

            processes.sort(key=lambda x: x.arrival)

            # FOREGROUND = SJFP
            # BACKGROUND = PNP

            while True:
                for p in processes:
                    if p.arrival == currentTime:
                        if p.algo_prio == 1:
                            r_queue_1.append(p)
                            p_count += 1
                        elif p.algo_prio == 2:
                            r_queue_2.append(p)
                            p_count += 1

                if len(r_queue_1) != 0:
                    r_queue_1.sort(key=lambda x: x.burst)
                    if current_p is None:
                        current_p = r_queue_1[0]

                    if current_p.index != r_queue_1[0].index and current_p.burst != 0:
                        final_queue.append(current_p)
                        task_width.append(currentTime)
                        current_p = r_queue_1[0]

                    r_queue_1[0].burst -= 1
                    currentTime += 1

                    if r_queue_1[0].burst == 0:
                        r_queue_1[0].time_finished = currentTime
                        final_queue.append(r_queue_1[0])
                        task_width.append(currentTime)
                        r_queue_1.pop(0)

                elif len(r_queue_2) != 0:
                    r_queue_2.sort(key=lambda x: x.prio)
                    if len(pp_queue) == 0:
                        pp_queue.append(r_queue_2[0])

                    if len(pp_queue) != 0:
                        pp_queue[0].burst -= 1
                        currentTime += 1

                        if pp_queue[0].burst == 0:
                            pp_queue[0].time_finished = currentTime
                            for p in r_queue_2:
                                if p.index == pp_queue[0].index:
                                    r_queue_2.remove(p)
                            final_queue.append(pp_queue[0])
                            task_width.append(currentTime)
                            pp_queue.pop(0)

                else:
                    currentTime += 1

                if len(r_queue_1) == 0 and len(r_queue_2) == 0 and p_count == num:
                    for p in processes:
                        p.turnaround = p.time_finished - p.arrival
                        p.waiting = p.turnaround - p.permaburst
                        total_turn += p.turnaround
                        total_wait += p.waiting

                        ave_turn = total_turn / num
                        ave_wait = total_wait / num
                    break

        print("Programmed by: Jan Edgar E. Tupas")
        print("MP04 - MULTILEVEL QUEUE ALGORITHM")
        print("Enter No. of Processes: {}".format(len(processes)))

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
            print("P{}: {}".format(p.index, p.prio))

        print("Classification(1-FP / 2-BP):")
        for p in processes:
            print("P{}: {}".format(p.index, p.algo_prio))

        print("Algorithm Choices:\n1. FCFS\n2. SJF-P\n3. SJF-NP\n4. P-P\n5. P-NP\n6. RR")

        print("Foreground Process: {}".format(fg_num))
        print("Background Process: {}".format(bg_num))

        # Gantt chart
        num_columns = len(final_queue)
        task_data = [p.index for p in final_queue]

        row_format = "| " + " | ".join(["{:^{}}"] * num_columns) + " |"

        test_width = []
        values = []
        for data, width in zip(task_data, task_width):
            values.append("P{}".format(data))
            values.append(width // 2)
            test_width.append(width // 2)

        formatted_row = row_format.format(*values)

        header_row = "+-{}-+".format("-+-".join("-" * (width) for width in test_width))
        footer_row = "+-{}-+".format("-+-".join("-" * (width) for width in test_width))
        label_row = [" " + " " * (width // 2) + str(width) for width in task_width]

        print("")

        print("Gantt Chart")
        print(header_row)

        print(formatted_row)

        print(footer_row)

        print("0 " + "".join(label_row))

        print("")

        # Table
        data = []
        processes.sort(key=lambda x: x.index)
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

        print(row_format.format("TOTAL", total_turn, total_wait))
        print(header)
        print(row_format.format("AVERAGE", f"{ave_turn:.2f}", f"{ave_wait:.2f}"))
        print(header)

        # Write the output to a text file
        file_path = "MP04 Checker.txt"

        with open(file_path, "a") as file:
            # Redirect the standard output to the file
            sys.stdout = file

            print("")
            print("Programmed by: Jan Edgar E. Tupas")
            print("MP04 - MULTILEVEL QUEUE ALGORITHM")
            print("Enter No. of Processes: {}".format(len(processes)))

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
                print("P{}: {}".format(p.index, p.prio))

            print("Classification(1-FP / 2-BP):")
            for p in processes:
                print("P{}: {}".format(p.index, p.algo_prio))

            print("Algorithm Choices:\n1. FCFS\n2. SJF-P\n3. SJF-NP\n4. P-P\n5. P-NP\n6. RR")

            print("Foreground Process: {}".format(fg_num))
            print("Background Process: {}".format(bg_num))

            # Gantt chart
            num_columns = len(final_queue)
            task_data = [p.index for p in final_queue]

            row_format = "| " + " | ".join(["{:^{}}"] * num_columns) + " |"

            test_width = []
            values = []
            for data, width in zip(task_data, task_width):
                values.append("P{}".format(data))
                values.append(width // 2)
                test_width.append(width // 2)

            formatted_row = row_format.format(*values)

            header_row = "+-{}-+".format("-+-".join("-" * (width) for width in test_width))
            footer_row = "+-{}-+".format("-+-".join("-" * (width) for width in test_width))
            label_row = [" " + " " * (width // 2) + str(width) for width in task_width]

            print("")

            print("Gantt Chart")
            print(header_row)

            print(formatted_row)

            print(footer_row)

            print("0 " + "".join(label_row))

            print("")

            # Table
            data = []
            processes.sort(key=lambda x: x.index)
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

            print(row_format.format("TOTAL", total_turn, total_wait))
            print(header)
            print(row_format.format("AVERAGE", f"{ave_turn:.2f}", f"{ave_wait:.2f}"))
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
