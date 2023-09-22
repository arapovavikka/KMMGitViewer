//
//  RepositoryViewModel.swift
//  iosApp
//
//  Created by Vika on 18.08.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Combine
import shared

enum LoaderState<T> {
	case loading
	case result(T)
	case error(String)
}

@MainActor
class RepositoryViewModel: ObservableObject {
	@Published var state: LoaderState<[RepositoryInfo]> = .loading
	
	private let provider: RepositoryApi
	
	init(provider: RepositoryApi) {
		self.provider = provider
		loadInitalData()
	}
	
	func loadInitalData() {
		Task {
			do {
				self.state = .loading
				let repositories = try await provider.getAllRepositories()
				self.state = .result(repositories)
			} catch {
				self.state = .error(error.localizedDescription)
			}
		}
	}

}
