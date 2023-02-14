package programa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import entities.Task;

public class Main {
	
	public static List<Task> activities(List<Task> tasks) {
		
		int index = 0;
		
		tasks.sort((task1, task2) -> task1.getFinish().compareTo(task2.getFinish()));
		
		Set<Task> selectAtivities = new HashSet<>();
		
		if(!tasks.isEmpty()) {
			selectAtivities.add(tasks.get(index));
		}
		
		for(int i = 1; i < tasks.size(); i++) {
			if(tasks.get(i).getStart() >= tasks.get(index).getFinish()) {
				selectAtivities.add(tasks.get(i));
				index = i;
			}
		}
		
		return selectAtivities
				.stream()
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		
		var scan = new Scanner(System.in);
		
		List<Task> tasks = new ArrayList<>();
		
		boolean loop = true;
		
		while(loop) {
			System.out.print("Digite o horário de entrada: ");
			int start = scan.nextInt();
			
			System.out.print("Digite o horário saida: ");
			int finish = scan.nextInt();
			
			tasks.add(new Task(start, finish));
			
			System.out.print("Continuar? (S/N): ");
			char answer = scan.next().charAt(0);
			
			if(answer == 'N' || answer == 'n') {
				loop = false;
			}
			
			System.out.println();
			
		}
		
		tasks = activities(tasks);
		tasks.sort((task1, task2) -> task1.getFinish().compareTo(task2.getFinish()));
		
		tasks.forEach(System.out::println);
		
		
		scan.close();

	}

}
